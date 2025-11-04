package tasks.task2test;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandNumbersGenArraysTest {

    // Test 1: Verify that the generated list contains numbers from 1 to 9
    @Test
    void testGenerateIntegersList() {
        List<Integer> listOfInts = IntStream.range(1, 10)
                .boxed()
                .toList();
        assertEquals(9, listOfInts.size()); // Check size
        assertEquals(Arrays.asList(1,2,3,4,5,6,7,8,9), listOfInts); // Check content
    }

    // Test 2: Verify that even numbers are correctly collected into an array
    @Test
    void testCollectEvenNumbersToArray() {
        List<Integer> listOfInts = IntStream.range(1, 10)
                .boxed()
                .toList();
        Integer[] ConvertedNumbersEvenArray = listOfInts.stream()
                .filter(num -> num % 2 == 0)
                .toArray(Integer[]::new);
        assertArrayEquals(new Integer[]{2,4,6,8}, ConvertedNumbersEvenArray);
    }

    // Test 3: Verify filtering, mapping, and sorting of strings
    @Test
    void testFilterConvertSort() {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        List<String> result = myList.stream()
                .filter(str -> str.startsWith("c"))
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .toList();
        assertEquals(Arrays.asList("C2", "C1"), result);
        assertTrue(result.stream().allMatch(str -> str.startsWith("C")));
    }
}