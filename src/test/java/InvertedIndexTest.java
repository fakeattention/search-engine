import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class InvertedIndexTest {

    private InvertedIndex index;

    @BeforeEach
    public void setUp() {
        List<String> data = List.of(
                "John Smith john.smith@example.com",
                "Jane Doe jane.doe@example.com",
                "Alice Johnson alice@example.com"
        );
        index = new InvertedIndex(data);
    }

    @Test
    public void testGetMatches_existingWord() {
        Set<String> results = index.getMatches("john");
        assertEquals(1, results.size()); 
        assertTrue(results.iterator().next().contains("John Smith"));
    }

    @Test
    public void testGetMatches_nonExistentWord() {
        Set<String> results = index.getMatches("nonexistent");

        
        assertTrue(results.isEmpty());
    }

    @Test
    public void testGetAllEntries() {
        Set<String> allEntries = index.getAllEntries();
        
        assertEquals(3, allEntries.size());
        assertTrue(allEntries.contains("John Smith john.smith@example.com"));
        assertTrue(allEntries.contains("Jane Doe jane.doe@example.com"));
        assertTrue(allEntries.contains("Alice Johnson alice@example.com"));
    }
}