package tasks.task4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayConcatenation {

    static void main(String[] args) {

        // Task 11a: Concatenating Multiple Arrays into a Single List using flatMap()
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(7, 8, 9);

        List<Integer> combinedMultipleArraysList = Stream.of(list1,list2,list3)
                .flatMap(List::stream)
                .toList();

        printFancyTable(combinedMultipleArraysList, "Task 11: Combined (Concatenated) List Using flatMap()");
        System.out.println();
        System.out.println();


        // Task 11b: Concatenating Array into a Single List using flatMap()
        String[][] dataArray = new String[][] {
                {"a", "b"}, {"c", "d"}, {"e", "f"}, {"g", "h"}
        };

        List<String> singleArraysList = Stream.of(dataArray) // Method Number 1
                .flatMap(Arrays::stream)
                .toList();

        /*List<String> SingleArraysList = Arrays.stream(dataArray) // Method Number 2
                .flatMap(Arrays::stream)
                .toList();*/

        printFancyTable(singleArraysList, "Task 11b: Flattened List from 2D Array Using flatMap()");
        System.out.println();
        System.out.println();


        // Task 12: Removing Duplicates from the previous List (Array)
        List<Integer> numbersList = Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7);
        List<String> uniqueDuplicateFreeList = numbersList.stream()
                .distinct()
                .map(String::valueOf)
                .toList();

        printFancyTable(uniqueDuplicateFreeList, "Task 12: Unique (Duplicate-Free) List using distinct()");
        System.out.println();
        System.out.println();


        // Task 13a: Moving list into a Map where key = element, value = frequency (Optional) Implementation #1
        // <Integer, Long> Implementation #1: counting() returns long
        Map<Integer, Long> numbersFrequencyMappingLong = numbersList.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        printFancyTable(numbersFrequencyMappingLong.entrySet().stream()
                .map(entry -> entry.getKey() + " -> " + entry.getValue() + " time(s)")
                .toList(), "Task 13b: Frequency of Each Number in the List (Long Values)");
        System.out.println();
        System.out.println();


        // Task 13b: Verify Moving list into a Map where key = element, value = frequency (Optional) Implementation #2
        // <Integer, Integer> Implementation #2: counting() returns Integer
        Map<Integer, Integer> numbersFrequencyMappingInteger = numbersList.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        printFancyTable(numbersFrequencyMappingInteger.entrySet().stream()
                .map(entry -> entry.getKey() + " -> " + entry.getValue() + " time(s)")
                .toList(), "Task 13b: Frequency of Each Number in the List (Integer Values)");
    }

    // Utility Method to Print Fancy Table
    public static void printFancyTable(List<?> items, String title) {
        int width = 70;
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