package tasks.task2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class RandNumbersGenArrays {

    static void main(String[] args) {

        // Task 3b: Generating a List of Integers from 1 to 9 using IntStream
        List<Integer> listOfInts = IntStream.range(1, 10)
                .boxed()
                .toList();
        printFancyTable(listOfInts, "Task 3b: List of Numbers from 1 to 9");
        System.out.println();
        System.out.println();

        // Task 4: Filtering Even Numbers from the List and Collecting into an Array
        Integer[] ConvertedNumbersEvenArray = listOfInts.stream()
                .filter(num -> num % 2 == 0)
                .toArray(Integer[]::new);
        printFancyTable(List.of(ConvertedNumbersEvenArray), "Task 4: Array of Even Numbers");
        System.out.println();
        System.out.println();

        // Task 5: Filtering, Mapping, and Sorting a List of Strings
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        List<String> result = myList.stream()
                .filter(str -> str.startsWith("c"))
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .toList();
        printFancyTable(result, "Task 5: Processed List of Strings");
    }

    public static void printFancyTable(List<?> items, String title) {
        int width = 52;
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