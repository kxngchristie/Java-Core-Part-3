package tasks.task3test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringListManipulationTest {

    @BeforeEach
    void preRequisiteList() {
        List<String> memberNames = Arrays.asList("Amitabh", "Shekhar", "Aman", "Rahul",
                "Shahrukh", "Abibaba", "Salman", "Yana", "Lokesh", "Lando");
    }

    // Task 6a: Verify that All Names Start with Letter 'A' and are more than 5 Characters long
    @Test
    void testNamesStartingWithAAndLongerThan5() {
        List<String> memberNames = Arrays.asList("Amitabh", "Shekhar", "Aman", "Rahul",
                "Shahrukh", "Abibaba", "Salman", "Yana", "Lokesh", "Lando");
        List<String> filteredNames = memberNames.stream()
                .filter(str -> str.startsWith("A") && str.length() > 5)
                .toList();
        assertEquals(Arrays.asList("Amitabh", "Abibaba"), filteredNames);
        assertTrue(filteredNames.stream().allMatch(str -> str.startsWith("A") && str.length() > 5));
    }

    // Task 6b: Verify Sorting Names and displaying them in lowercase
    @Test
    void testSortingNamesInLowercase() {
        List<String> memberNames = Arrays.asList("Amitabh", "Shekhar", "Aman", "Rahul",
                "Shahrukh", "Abibaba", "Salman", "Yana", "Lokesh", "Lando");
        List<String> filterNames = memberNames.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::toLowerCase)
                .toList();
        assertTrue(filterNames.stream().allMatch(str -> str.equals(str.toLowerCase())));
    }

    // Task 7a: Verify if the list contains names with the letter ‘S’ (Any Match / All Match)
    @Test
    void testNamesContainingS() {
        List<String> memberNames = Arrays.asList("Amitabh", "Shekhar", "Aman", "Rahul",
                "Shahrukh", "Abibaba", "Salman", "Yana", "Lokesh", "Lando");

        Predicate<String> containsS = str -> str.toUpperCase().contains("S"); // Case Insensitive Check

        assertFalse(memberNames.stream().allMatch(containsS));
        assertTrue(memberNames.stream().anyMatch(containsS));
    }

    // Task 7b: Verify if the list contains names with the letter ‘H’ (None Match)
    @Test
    void testNamesContainingH() {
        List<String> memberNames = Arrays.asList("Amitabh", "Shekhar", "Aman", "Rahul",
                "Shahrukh", "Abibaba", "Salman", "Yana", "Lokesh", "Lando");

        Predicate<String> containsH = str -> str.toUpperCase().contains("H"); // Case Insensitive Check

        assertFalse(memberNames.stream().noneMatch(containsH));
    }

    // Task 8-9: Verify the Numbers of Names Starting with 'A'
    @Test
    void testCountNamesStartingWithA() {
        List<String> memberNames = Arrays.asList("Amitabh", "Shekhar", "Aman", "Rahul",
                "Shahrukh", "Abibaba", "Salman", "Yana", "Lokesh", "Lando");

        long countNamesStartingWithA = memberNames.stream()
                .filter(str -> str.startsWith("A"))
                .count();
        assertEquals(3, countNamesStartingWithA);
    }

    // Task 10a: Verify the first name starting with the letter 'L'
    @Test
    void testFirstNameStartingWithL() {
        List<String> memberNames = Arrays.asList("Amitabh", "Shekhar", "Aman", "Rahul",
                "Shahrukh", "Abibaba", "Salman", "Yana", "Lokesh", "Lando");

        Optional<String> firstNameStartingWithL = memberNames.stream()
                .filter(str -> str.startsWith("M"))
                .findFirst();
        assertTrue(firstNameStartingWithL.isPresent());
        assertTrue(firstNameStartingWithL.get().startsWith("M"));
    }

    // Task 10b: Verify any name starting with the letter 'L'
    @Test
    void testAnyNameStartingWithL() {
        List<String> memberNames = Arrays.asList("Amitabh", "Shekhar", "Aman", "Rahul",
                "Shahrukh", "Abibaba", "Salman", "Yana", "Lokesh", "Lando");

        Optional<String> anyNameStartingwithL = memberNames.stream()
                .filter(str -> str.startsWith("L"))
                .findAny();
        assertTrue(anyNameStartingwithL.isPresent());
        assertTrue(anyNameStartingwithL.get().startsWith("L"));
    }

    // Task 10c: Verify all names starting with the letter 'L'
    @Test
    void testAllNameStartingWithL() {
        List<String> memberNames = Arrays.asList("Amitabh", "Shekhar", "Aman", "Rahul",
                "Shahrukh", "Abibaba", "Salman", "Yana", "Lokesh", "Lando");

        Optional<String> allNamesStartingWithL = memberNames.stream()
                .filter(str -> str.startsWith("L"))
                .findAny();
        assertTrue(allNamesStartingWithL.isPresent());
        assertTrue(allNamesStartingWithL.get().startsWith("L"));
    }
}