import java.util.List;
import java.util.Set;
/**
 * Search for strings containing all words from the query.
 */
public class SearchAll implements SearchStrategy {
    @Override
    public Set<String> search(InvertedIndex index, List<String> words) {
        return words.stream()
                .map(index::getMatches)
                .reduce((a, b) -> {
                    a.retainAll(b);
                    return a;
                })
                .orElse(Set.of());
    }
}