import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Search for strings that do NOT contain any of the words from the query.
 */
public class SearchNone implements SearchStrategy {
    @Override
    public Set<String> search(InvertedIndex index, List<String> words) {
        return words.stream()
                .map(word -> index.getMatches(word))
                .reduce(new HashSet<>(index.getAllEntries()), (result, matches) -> {
                    result.removeAll(matches);
                    return result;
                });
    }
}