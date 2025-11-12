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
    void testManualStreamOfElements() {
        List<Integer> manualStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).toList();

        assertEquals(Arrays.asList(1,2,3,4,5,6,7,8,9), manualStream);,
    }


    // Task 2: Verify generation of 20 random numbers within range
    @Test
    void testGenerateRandomNumbers() {
        List<Integer> randomNumbers = Stream.generate(() -> new Random().nextInt(100)) // Supplier generating random integers between 0 and 99
                .limit(20)
                .toList();

        assertEquals(20, randomNumbers.size());
        assertTrue(randomNumbers.stream().allMatch(num -> num >= 0 && num < 100));
    }


    // Task 3a: Verify filtering of even numbers from the generated numbers' list
    @Test
    void testCollectEvenNumbers() {
        List<Integer> randomNumbers = Stream.generate(() -> new Random().nextInt(100))
                .limit(20)
                .toList();
        List<Integer> randomNumbersEven = randomNumbers.stream()
                .filter(num -> num % 2 == 0)
                .toList();

        assertTrue(randomNumbersEven.size() >= 2); // At least 2 even numbers expected
        assertTrue(randomNumbersEven.stream().allMatch(num -> num % 2 == 0)); // All numbers should be even
        assertTrue(randomNumbers.containsAll(randomNumbersEven)); // Even numbers should be from the original list
        assertEquals(randomNumbers.stream().filter(n -> n % 2 == 0).count(),
                randomNumbersEven.size()); // Sizes should match
    }
}