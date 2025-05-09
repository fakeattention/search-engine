import java.util.List;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        List<String> customers = DataLoader.load("data.txt");
        if (customers.isEmpty()) {
            System.out.println("No data loaded. Bye!");
            return;
        }

        InvertedIndex index = new InvertedIndex(customers);
        CustomerSearch searchEngine = new CustomerSearch(index);

        Menu menu = new Menu(scanner, searchEngine, customers);
        menu.displayMenuAndHandleChoice();
    }
}