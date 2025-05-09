import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class SearchAllTest {

    @Test
    public void testSearchAll() {
        InvertedIndex index = new InvertedIndex(List.of(
                "John Smith john@example.com",
                "Alice Smith alice@example.com"
        ));

        SearchStrategy strategy = new SearchAll();
        Set<String> results = strategy.search(index, List.of("smith", "john"));
        
        assertEquals(1, results.size());
        assertTrue(results.iterator().next().contains("John Smith"));
    }

    @Test
    public void testSearchAll_negativeCase() {
        InvertedIndex index = new InvertedIndex(List.of("John Smith john@example.com"));

        SearchStrategy strategy = new SearchAll();
        Set<String> results = strategy.search(index, List.of("nonexistent"));
        
        assertTrue(results.isEmpty());
    }
}