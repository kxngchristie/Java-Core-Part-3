package tasks.task4test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayConcatenationTest {

    List<Integer> numbersList = Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7);

    // Task 11a: Verify Concatenating Multiple Arrays into a Single List
    @Test
    void testMultipleArraysConcatenation() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(7, 8, 9);

        List<Integer> combinedMultipleArraysList = Stream.of(list1,list2,list3)
                .flatMap(List::stream)
                .toList();

        assertEquals(9, combinedMultipleArraysList.size());
        assertEquals(Arrays.asList(1,2,3,4,5,6,7,8,9), combinedMultipleArraysList);
    }


    // Task 11b: Verify Concatenating Array into a Single List
    @Test
    void testSingleArrayConcatenation() {
        String[][] dataArray = new String[][] {
                {"a", "b"}, {"c", "d"}, {"e", "f"}, {"g", "h"}
        };

        List<String> singleArraysList = Stream.of(dataArray)
                .flatMap(Arrays::stream)
                .toList();

        assertEquals(8, singleArraysList.size());
        assertEquals(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), singleArraysList);
    }


    // Task 12: Verify Removing Duplicates from the previous List (Array)
    @Test
    void testRemovingDuplicates() {
        List<String> uniqueDuplicateFreeList = numbersList.stream()
                .distinct()
                .map(String::valueOf)
                .toList();

        assertEquals(7, uniqueDuplicateFreeList.size());
        // assertEquals(Arrays.asList(1,2,3,4,5,6,7).stream().map(String::valueOf).toList(), uniqueDuplicateFreeList); // Implementation #1
        assertEquals(Stream.of(1,2,3,4,5,6,7).map(String::valueOf).toList(), uniqueDuplicateFreeList); // Implementation #2
    }


    // Task 13a: Verify Moving list into a Map where key = element, value = frequency (Optional) Implementation #1
    // <Integer, Long> Implementation #1: counting() returns long
    @Test
    void testFrequencyMappingLong() {
        Map<Integer, Long> numbersFrequencyMappingLong = numbersList.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        assertEquals(2L, numbersFrequencyMappingLong.get(1));
        assertEquals(1L, numbersFrequencyMappingLong.get(2));
    }


    // Task 13b: Verify Moving list into a Map where key = element, value = frequency (Optional) Implementation #2
    // <Integer, Integer> Implementation #2: counting() returns Integer
    @Test
    void testFrequencyMappingInteger() {
        Map<Integer, Integer> numbersFrequencyMappingInteger = numbersList.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        assertEquals(2, numbersFrequencyMappingInteger.get(1));
        assertEquals(1, numbersFrequencyMappingInteger.get(2));
    }
}