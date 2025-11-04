package practice.streamsexample;

import java.util.Arrays;
import java.util.stream.Stream;

public class _Stream2 {

    static void main(String[] args) {

        Employee[] arrayOfEmployees = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        };
        Stream.of(arrayOfEmployees);

        System.out.println("\nEMPLOYEES WITH SALARIES LESS THAN $200,000: " +
                Arrays.stream(arrayOfEmployees)
                        .filter(e -> e.salary < 200000.0)
                        .count());
    }

    private static class Employee {
        int id;
        String name;
        double salary;

        Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }
    }
}