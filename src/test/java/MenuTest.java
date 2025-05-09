import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.*;

class MenuTest {
    private Menu menu;
    private Scanner scanner;
    private CustomerSearch searchEngine;
    private List<String> customers;

    @BeforeEach
    void setUp() {
        scanner = mock(Scanner.class);
        customers = Arrays.asList("John Doe", "Jane Doe", "Jack Daniels");

        searchEngine = mock(CustomerSearch.class);

        menu = new Menu(scanner, searchEngine, customers);
    }

    @Test
    void testDisplayMenuAndHandleChoice_Option1_Search() {
        when(scanner.nextLine()).thenReturn("1", "ALL", "John Doe");

        when(searchEngine.search(any())).thenReturn(List.of("John Doe"));

        menu.displayMenuAndHandleChoice(1);

        verify(scanner, times(3)).nextLine();
        verify(searchEngine, times(1)).search(any());
    }

    @Test
    void testDisplayMenuAndHandleChoice_Option2_PrintAllCustomers() {
        when(scanner.nextLine()).thenReturn("2");

        menu.displayMenuAndHandleChoice(1);

        verify(scanner).nextLine();
    }

    @Test
    void testDisplayMenuAndHandleChoice_Option0_Exit() {
        when(scanner.nextLine()).thenReturn("0");

        menu.displayMenuAndHandleChoice(1); // сразу выход

        verify(scanner).nextLine();
    }
}