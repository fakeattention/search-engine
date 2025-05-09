import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CustomerSearchTest {

    @Test
    public void testSearchALLStrategy() {
        InvertedIndex index = new InvertedIndex(List.of("Jane Doe jane@example.com"));
        CustomerSearch search = new CustomerSearch(index);

        SearchRequest request = SearchRequest.create("ALL", "Jane");
        List<String> results = search.search(request);
        
        assertFalse(results.isEmpty());
        assertTrue(results.contains("Jane Doe jane@example.com"));
    }

    @Test
    public void testInvalidStrategyThrowsException() {
        InvertedIndex index = new InvertedIndex(List.of("Test User user@example.com"));
        CustomerSearch search = new CustomerSearch(index);

        SearchRequest request = SearchRequest.create("UNKNOWN", "User");
        
        assertThrows(IllegalArgumentException.class, () -> search.search(request), "Invalid strategy: UNKNOWN");
    }

    @Test
    public void testSearchForNonExistingUser() {
        InvertedIndex index = new InvertedIndex(List.of("Jane Doe jane@example.com"));
        CustomerSearch search = new CustomerSearch(index);

        SearchRequest request = SearchRequest.create("ALL", "Nonexistent");

        List<String> results = search.search(request);
        
        assertTrue(results.isEmpty());
    }
}