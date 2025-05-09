import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SearchRequestTest {

    @Test
    public void testQuerySplitAndLowercase() {
        SearchRequest request = SearchRequest.create("ALL", "John DOE");
        List<String> words = request.getQueryWords();
        
        assertEquals(2, words.size());
        assertTrue(words.contains("john"));
        assertTrue(words.contains("doe"));
    }

    @Test
    public void testNullQueryThrows() {
        assertThrows(IllegalArgumentException.class, () -> SearchRequest.create("ANY", null), "Query cannot be null");
    }

    @Test
    public void testEmptyQueryThrows() {
        assertThrows(IllegalArgumentException.class, () -> SearchRequest.create("ANY", ""), "Query cannot be null or empty");
    }

    @Test
    public void testEmptyStrategyThrows() {
        assertThrows(IllegalArgumentException.class, () -> SearchRequest.create(" ", "test"), "Strategy name cannot be null or empty");
    }
}