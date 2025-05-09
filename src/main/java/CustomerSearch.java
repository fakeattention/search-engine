import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CustomerSearch {
    private final InvertedIndex index;

    public CustomerSearch(InvertedIndex index) {
        this.index = index;
    }

    public List<String> search(SearchRequest request) {
        SearchStrategy strategy = switch (request.getStrategyName()) {
            case "ALL" -> new SearchAll();
            case "ANY" -> new SearchAny();
            case "NONE" -> new SearchNone();
            default -> throw new IllegalArgumentException("Invalid strategy: " + request.getStrategyName());
        };

        Set<String> results = strategy.search(index, request.getQueryWords());
        return new ArrayList<>(results);
    }
}