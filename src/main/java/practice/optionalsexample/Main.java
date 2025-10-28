package practice.optionalsexample;

import java.util.Optional;
import java.util.function.Consumer;

public class Main {

    static void main(String[] args) {

        Optional.ofNullable( null)
                .ifPresentOrElse(
                        email -> System.out.println("Sending Email to " + email),
                        () -> System.out.println("Cannot Send Email"));
    }
}