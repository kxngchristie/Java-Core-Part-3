package tasks.task1;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class RandNumbersGen {

    static void main(String[] args) {

        // Task 1: Manual Stream.of()
        List<Integer> manualStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).toList();
        printFancyTable(manualStream, "Task 1: List of Numbers Manually Added to Stream");
        System.out.println();
        System.out.println();

        // Task 2: Generate a List of 20 Random Numbers between 0 and 99
        List<Integer> randomNumbers = Stream.generate(() -> new Random().nextInt(100)) // Supplier generating random integers between 0 and 99
                .limit(20)
                .toList();
        printFancyTable(randomNumbers, "Task 2: List of 20 Generated Random Numbers");
        System.out.println();
        System.out.println();

        // Task 3a: Filter even numbers from generated list
        List<Integer> randomNumbersEven = randomNumbers.stream()
                .filter(num -> num % 2 == 0)
                .toList();
        printFancyTable(randomNumbersEven, "Task 3a: List of Even Numbers from Generated List");
    }

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