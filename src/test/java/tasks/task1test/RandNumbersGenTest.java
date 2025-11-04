package tasks.task1test;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandNumbersGenTest {

    // Task 1: Verify Stream.of() contains expected elements
    @Test
    void testStreamOfElements() {
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
        List<Integer> result = stream.toList();
        assertEquals(Arrays.asList(1,2,3,4,5,6,7,8,9), result);
    }

    // Task 2: Verify generation of 20 random numbers within range
    @Test
    void testGenerateRandomNumbers() {
        List<Integer> randomNumbers = Stream.generate(() -> new Random().nextInt(100))
                .limit(20)
                .toList();
        assertEquals(20, randomNumbers.size());
        assertTrue(randomNumbers.stream().allMatch(num -> num >= 0 && num < 100));
    }

    // Task 3: Verify filtering of even numbers from a list
    @Test
    void testCollectEvenNumbers() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> randomNumbersEven = list.stream()
                .filter(num -> num % 2 == 0) // Filtering Even Numbers
                .toList();
        assertEquals(Arrays.asList(2,4,6,8,10), randomNumbersEven);
        assertTrue(randomNumbersEven.stream().allMatch(num -> num % 2 == 0));
    }
}