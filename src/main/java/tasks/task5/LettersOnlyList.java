package tasks.task5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LettersOnlyList {

    static void main(String[] args) {

        // Task 14: Letters-Only List Implementation
        Map<String, List<String>> people = new HashMap<>(); // Random Insertion Order
        // Map<String, List<String>> people = new LinkedHashMap<>(); // Preserved Insertion Order
        people.put("John", Arrays.asList("555-1123", "s", "555-3389", "a"));
        people.put("Mary", Arrays.asList("555-2243", "z", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242", "d"));

        List<String> lettersOnlyList = people.values().stream()
                .flatMap(List::stream)
                .filter(str -> str.matches("[a-zA-Z]"))
                .sorted(Comparator.naturalOrder()) // Can be Removed if the LinkedList Implementation is used tho it wont be natural order it will be the original insertion order
                .toList();

        printFancyTable(lettersOnlyList, "Task 14: Letters Only from Map Values");
    }

    // Utility Method to Print Fancy Table
    public static void printFancyTable(List<?> items, String title) {
        int width = 60;
        String border = "+" + "-".repeat(width - 2) + "+";

        System.out.println(border);
        System.out.printf("|%s|\n", centerText(title, width - 2));
        System.out.println(border);

        for (Object item : items) {
            System.out.printf("|%s|\n", centerText(item.toString(), width - 2));
        }

        System.out.println(border);
    }

    private static String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        String spaces = " ".repeat(Math.max(0, padding));
        String extra = (text.length() % 2 == 0) ? "" : " "; // handle odd lengths
        return spaces + text + spaces + extra;
    }
}
