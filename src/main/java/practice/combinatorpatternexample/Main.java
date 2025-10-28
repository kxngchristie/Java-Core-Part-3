package practice.combinatorpatternexample;

import java.time.LocalDate;

public class Main {

    static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+0958765432",
                LocalDate.of(2000,1,20));

        // System.out.println(new CustomerValidatorService().isCustomerValid(customer));

        // Using Combinator Pattern
        // Option enter can be used to make it even cleaner
        CustomerRegistrationValidator.ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAnAdult())
                .apply(customer);

        System.out.println(result);

        if (result != CustomerRegistrationValidator.ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }

    // If valid We can store customer in DB
}