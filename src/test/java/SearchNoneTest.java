import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class SearchNoneTest {

    @Test
    public void testSearchNone() {
        InvertedIndex index = new InvertedIndex(List.of(
                "John Smith john@example.com",
                "Alice Wonderland alice@example.com",
                "Bob Brown bob@example.com"
        ));

        SearchStrategy strategy = new SearchNone();
        Set<String> results = strategy.search(index, List.of("john"));
        
        assertEquals(2, results.size());
        results.forEach(r -> assertFalse(r.toLowerCase().contains("john")));
    }

    @Test
    public void testSearchNone_negativeCase() {
        InvertedIndex index = new InvertedIndex(List.of(
                "John Smith john@example.com",
                "Alice Wonderland alice@example.com",
                "Bob Brown bob@example.com"
        ));

        SearchStrategy strategy = new SearchNone();
        Set<String> results = strategy.search(index, List.of("john"));
        
        assertTrue(results.size() == 2);
        results.forEach(r -> assertFalse(r.toLowerCase().contains("john")));
    }
}