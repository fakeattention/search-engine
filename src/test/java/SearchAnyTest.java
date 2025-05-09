import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class SearchAnyTest {

    @Test
    public void testSearchAny() {
        InvertedIndex index = new InvertedIndex(List.of(
                "John Smith john@example.com",
                "Alice Johnson alice@example.com"
        ));

        SearchStrategy strategy = new SearchAny();
        Set<String> results = strategy.search(index, List.of("john", "alice"));
        
        assertEquals(2, results.size());
    }

    @Test
    public void testSearchAny_negativeCase() {
        InvertedIndex index = new InvertedIndex(List.of("John Smith john@example.com"));

        SearchStrategy strategy = new SearchAny();
        Set<String> results = strategy.search(index, List.of("nonexistent"));
        
        assertTrue(results.isEmpty());
    }
}