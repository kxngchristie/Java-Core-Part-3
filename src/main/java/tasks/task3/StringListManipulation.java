package tasks.task3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class StringListManipulation {

    static void main(String[] args) {

        // Task 6a: Displaying All Names Starting with Letter 'A' and are more than 5 Characters long
        List<String> memberNames = Arrays.asList("Amitabh", "Shekhar", "Aman", "Rahul",
                "Shahrukh", "Abibaba", "Salman", "Yana", "Lokesh", "Lando");

        List<String> filteredNames = memberNames.stream()
                .filter(str -> str.startsWith("A") && str.length() >5)
                .toList();
        printFancyTable(filteredNames, "Task 6a: Displaying Names Starting with Letter 'A' and are more than 5 Characters long");
        System.out.println();

        // Task 6b: Sorting Names and displaying them in lowercase
        List<String> sortedLowercaseNames = memberNames.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::toLowerCase)
                .toList();
        printFancyTable(sortedLowercaseNames, "Task 6b: Sorting Names and displaying them in lowercase");
        System.out.println();
        System.out.println();

        // Task 7a: Checking if the list contains names with the letter ‘S’ (Any Match / All Match)
        Predicate<String> containsS = str -> str.toUpperCase().contains("S"); // Case Insensitive Check
        boolean allMatchResult = memberNames.stream().allMatch(containsS);
        boolean anyMatchResult = memberNames.stream().anyMatch(containsS);

        List<String> namesWithS = memberNames.stream()
                .filter(containsS)
                .toList();
        printFancyTable(namesWithS, "Task 7a: Names containing the letter 'S'");
        printFancyTable(Collections.singletonList(allMatchResult), "Do all names contain 'S'?");
        printFancyTable(Collections.singletonList(anyMatchResult), "Does any name contain 'S'?");
        System.out.println();

        // Task 7b: Checking if the list contains names with the letter ‘H’ (None Match)
        Predicate<String> containsH = str -> str.toUpperCase().contains("H");
        boolean noneMatchResult = memberNames.stream().noneMatch(containsH);

        List<String> namesWithH = memberNames.stream()
                .filter(containsH)
                .toList();
        printFancyTable(namesWithH, "Task 7b: Names containing the letter 'H'");
        printFancyTable(Collections.singletonList(noneMatchResult), "Are there any names that don't contain 'H'?");
        System.out.println();
        System.out.println();

        // Task 8-9: Counting the Numbers of Names Starting with 'A'
        long countNamesStartingWithA = memberNames.stream()
                .filter(str -> str.startsWith("A"))
                .count();
        printFancyTable(Collections.singletonList(countNamesStartingWithA), "Task 8-9: Names Starting with the letter 'A'");
        System.out.println();
        System.out.println();

        // Task 10a: Finding the first name starting with 'L'
        Optional<String> firstNameStartingWithL = memberNames.stream()
                .filter(str -> str.startsWith("L"))
                .findFirst();
        printFancyTable(Collections.singletonList(firstNameStartingWithL.orElse("No Name Found")), "Task 10a: First Name Starting with the Letter 'L'");
        System.out.println();

        // Task 10b: Finding any name starting with 'L'
        Optional<String> anyNameStartingWithL = memberNames.stream()
                .filter(str -> str.startsWith("L"))
                .findAny();
        printFancyTable(Collections.singletonList(anyNameStartingWithL.orElse("No Name Found")), "Task 10b: Any Starting with the Letter 'L'");
        System.out.println();

        // Task 10c: Finding all names starting with 'L'
        List<String> allNamesStartingWithL = memberNames.stream()
                .filter(str -> str.startsWith("L"))
                .toList();
        printFancyTable(allNamesStartingWithL, "Task 10c: All Names Starting with the Letter 'L'");
        System.out.println();
        System.out.println();
    }

    public static void printFancyTable(List<?> items, String title) {
        int width = 94;
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