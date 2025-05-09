import java.util.*;

public class Menu {
    private final Scanner scanner;
    private final CustomerSearch searchEngine;
    private final List<String> customers;

    public Menu(Scanner scanner, CustomerSearch searchEngine, List<String> customers) {
        this.scanner = scanner;
        this.searchEngine = searchEngine;
        this.customers = new ArrayList<>(customers);
    }

    public void displayMenuAndHandleChoice() {
        displayMenuAndHandleChoice(-1);
    }

    public void displayMenuAndHandleChoice(int maxIterations) {
        int count = 0;
        while (maxIterations < 0 || count < maxIterations) {
            String choice = getUserChoice();
            switch (choice) {
                case "1":
                    executeSearch();
                    break;
                case "2":
                    displayAllCustomers();
                    break;
                case "0":
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Incorrect option! Try again.");
            }
            count++;
        }
    }

    private String getUserChoice() {
        System.out.println("\n=== Menu ===\n1. Find a person\n2. Print all people\n0. Exit");
        return scanner.nextLine().trim();
    }

    private void executeSearch() {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        String strategyName = scanner.nextLine().trim().toUpperCase(Locale.ROOT);

        System.out.println("Enter a name or email to search:");
        String query = scanner.nextLine();

        List<String> results = searchEngine.search(SearchRequest.create(strategyName, query));
        displaySearchResults(results);
    }

    private void displayAllCustomers() {
        System.out.println("\n=== List of people ===");
        customers.forEach(System.out::println);
    }

    private void displaySearchResults(List<String> results) {
        if (results.isEmpty()) {
            System.out.println("No matching customers found.");
        } else {
            results.forEach(System.out::println);
        }
    }
}
