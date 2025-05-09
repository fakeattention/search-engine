import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SearchStrategyTest {

    @Test
    public void testSearchAllMatches() {
        InvertedIndex index = new InvertedIndex(List.of(
                "Jane Doe jane@example.com",
                "John Doe john@example.com"
        ));
        SearchAll strategy = new SearchAll();
        Set<String> results = strategy.search(index, List.of("doe"));
        assertEquals(2, results.size());
    }

    @Test
    public void testSearchAnyMatches() {
        InvertedIndex index = new InvertedIndex(List.of(
                "Jane Smith jane@sample.com",
                "Bob Doe bob@abc.com"
        ));
        SearchAny strategy = new SearchAny();
        Set<String> results = strategy.search(index, List.of("jane", "bob"));
        assertEquals(2, results.size());
    }

    @Test
    public void testSearchNoneExcludesCorrectly() {
        InvertedIndex index = new InvertedIndex(List.of(
                "Jane Smith jane@sample.com",
                "Bob Doe bob@abc.com"
        ));
        SearchNone strategy = new SearchNone();
        Set<String> results = strategy.search(index, List.of("bob"));
        assertEquals(1, results.size());
        assertTrue(results.contains("Jane Smith jane@sample.com"));
    }
}