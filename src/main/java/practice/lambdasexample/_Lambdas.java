package practice.lambdasexample;

import java.util.function.BiFunction;

public class _Lambdas {

    static void main(String[] args) {
        BiFunction<String, Integer, String> upperCaseName = (name, age) -> {
            // Logic
            if (name.isBlank()) throw new IllegalArgumentException("");
            System.out.println(age);
            return name.toUpperCase();
        };

        System.out.println(upperCaseName.apply("Alex", 20));
    }
}