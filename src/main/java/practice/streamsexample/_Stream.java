package practice.streamsexample;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class _Stream {

    static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Person.Gender.MALE),
                new Person("Maria", Person.Gender.FEMALE),
                new Person("Ayesha", Person.Gender.FEMALE),
                new Person("Alex", Person.Gender.MALE),
                new Person("Alice", Person.Gender.FEMALE),
                new Person("Bob", Person.Gender.PREFER_NOT_TO_SAY)
        );

        System.out.println();
        // These are Inlined with Command Option N
        /* Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println; */
        /*people.stream()
                .map(person -> person.name) // Mapping Genders to List
                // .collect(Collectors.toSet()) // Removes Duplicate Strings, etc
                .mapToInt(String::length) // Count the length of each name
                .forEach(System.out::println); // Print Each*/

        // Can be Inlined for better readability
        /*boolean containsOnlyFemales = people.stream()
                .allMatch(person1 -> Person.Gender.FEMALE.equals(person1.gender));*/

        Predicate<Person> personPredicate = person -> Person.Gender.FEMALE.equals(person.gender);
        boolean containsOnlyFemales = people.stream()
                .allMatch(personPredicate);

        System.out.println(containsOnlyFemales);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person {" +
                    "Name: " + name + ", Gender: " + gender + '}';
        }

        enum Gender {
            MALE, FEMALE, PREFER_NOT_TO_SAY
        }
    }
}