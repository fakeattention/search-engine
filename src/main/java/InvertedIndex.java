import java.util.*;
import java.util.Locale;

public class InvertedIndex {
    private final Map<String, Set<String>> index = new HashMap<>();
    private final Set<String> allEntries = new HashSet<>();

    public InvertedIndex(List<String> customers) {
        allEntries.addAll(customers);
        for (String customer : customers) {
            Arrays.stream(customer.toLowerCase(Locale.ROOT).split("\\s+"))
                    .forEach(word -> {
                        index.computeIfAbsent(word, k -> new HashSet<>()).add(customer);
                    });
        }
    }

    public Set<String> getMatches(String word) {
        return index.getOrDefault(word.toLowerCase(Locale.ROOT), Set.of());
    }

    public Set<String> getAllEntries() {
        return new HashSet<>(allEntries);
    }
}