import java.util.List;
import java.util.Set;

public interface SearchStrategy {
    Set<String> search(InvertedIndex index, List<String> words);
}