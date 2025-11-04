package tasks.task1;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class RandNumbersGen {

    static void main(String[] args) {

        // Manual Addition of Elements to Stream to Output.
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
        System.out.println("\nList of Numbers Manually Added to Stream:");
        stream.forEach(System.out::println); // Printing all Elements in the Stream

        // Generating a Stream of Random Numbers with a limit.
        List<Integer> randomNumbers = Stream.generate(() -> new Random().nextInt(100)) // Supplier generating random integers between 0 and 99
                .limit(20)
                .toList(); // Collecting the first 20 random integers into a List
        System.out.println("\nList of 20 Random Numbers:");
        randomNumbers.forEach(System.out::println); // Printing all Random Numbers

        // Filtering Even Numbers from a List of Integers.
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> randomNumbersEven = list.stream()
                .filter(num -> num % 2 == 0) // Filtering Even Numbers
                .toList(); // Collecting Even Numbers into a List
        System.out.println("\nList of Even Random Numbers:");
        randomNumbersEven.forEach(System.out::println);
    }
}