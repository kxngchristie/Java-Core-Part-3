package tasks.task5test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LettersOnlyListTest {

    // Task 14: Verify Letters-Only List Implementation
    @Test
    void testLettersOnlyList() {
        Map<String, List<String>> people = new HashMap<>();
        // Map<String, List<String>> people = new LinkedHashMap<>(); // Preserved Insertion Order
        people.put("John", Arrays.asList("555-1123", "s", "555-3389", "a"));
        people.put("Mary", Arrays.asList("555-2243", "z", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242", "d"));

        List<String> lettersOnlyList = people.values().stream()
                .flatMap(List::stream)
                .filter(str -> str.matches("[a-zA-Z]"))
                .sorted(Comparator.naturalOrder())
                .toList();

        assertEquals(Arrays.asList("a","d","s","z"), lettersOnlyList);
    }
}
