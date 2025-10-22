package practice.imperativedeclarativeexample;

import java.util.List;
import java.util.function.Predicate;

public class Prac1 {
    static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Ayesha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE)
        );

        // Imperative Approach
        /*System.out.println("\nImperative Approach");
        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (Gender.FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        for (Person female : females) {
            System.out.println(female);
        }*/

        // Declarative / Functional Approach
        System.out.println("\nDeclarative / Functional Approach");
        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);

        List <Person> females = people.stream()
                .filter(personPredicate)
                .toList();
                females.forEach(System.out::println);
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
                    "Name: " + name  + ", Gender: " + gender + '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}