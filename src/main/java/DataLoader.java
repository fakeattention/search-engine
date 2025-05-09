import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataLoader {
    public static List<String> load(String filename) {
        try {
            return Files.readAllLines(Path.of(filename));
        } catch (IOException e) {
            throw new RuntimeException("Error loading file: " + e.getMessage());
        }
    }
}