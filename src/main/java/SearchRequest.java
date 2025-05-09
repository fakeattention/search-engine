import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class SearchRequest {
    private final String strategyName;
    private final List<String> queryWords;

    private SearchRequest(String strategyName, List<String> queryWords) {
        this.strategyName = strategyName;
        this.queryWords = Collections.unmodifiableList(queryWords);
    }

    public static SearchRequest create(String strategyName, String query) {
        if (strategyName == null || strategyName.trim().isEmpty()) {
            throw new IllegalArgumentException("Strategy name cannot be null or empty");
        }
        if (query == null || query.trim().isEmpty()) {
            throw new IllegalArgumentException("Query cannot be null or empty");
        }

        List<String> wordsList = new ArrayList<>();
        for (String word : query.toLowerCase(Locale.ROOT).split("\\s+")) {
            if (!word.isEmpty()) {
                wordsList.add(word);
            }
        }

        return new SearchRequest(strategyName, wordsList);
    }

    public String getStrategyName() {
        return strategyName;
    }

    public List<String> getQueryWords() {
        return new ArrayList<>(queryWords);
    }
}