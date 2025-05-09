import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * Search for strings containing at least one word from the query.
 */
public class SearchAny implements SearchStrategy {
    @Override
    public Set<String> search(InvertedIndex index, List<String> words) {
        return words.stream()
                .flatMap(word -> index.getMatches(word).stream())
                .collect(Collectors.toSet());
    }
}