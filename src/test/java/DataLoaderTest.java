import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DataLoaderTest {

    @Test
    public void testLoadValidFile() throws IOException {
        Path tempFile = Files.createTempFile("test", ".txt");
        Files.write(tempFile, List.of("John Doe", "Jane Smith"));

        List<String> result = DataLoader.load(tempFile.toString());
        assertEquals(2, result.size());
        assertTrue(result.contains("John Doe"));
    }

    @Test
    public void testLoadInvalidFileThrowsException() {
        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> DataLoader.load("nonexistent.txt"));
        assertTrue(ex.getMessage().contains("Error loading file"));
    }
}