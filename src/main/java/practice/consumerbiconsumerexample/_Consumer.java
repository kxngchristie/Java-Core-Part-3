package practice.consumerbiconsumerexample;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _ConsumerBiCons {
    static void main(String[] args) {
        // Normal Java Function Approach
        Customer customer = new Customer("Marcus", "123-456-7890");
        Customer.greetCustomer(customer);

        //Consumer Function Interface Approach
        Customer.greetCustomerConsumer.accept(customer);

        //Bi Consumer Function Interface Approach
        Customer.greetCustomerBiConsumer.accept(customer, false);
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

        //Bi Consumer Function Interface Approach
        static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, showPhoneNumber) ->
                System.out.println("Hello " + customer.customerName +
                        ", Thanks for registering the phone number " +
                        (showPhoneNumber ? customer.customerPhoneNumber : "*********"));

        //Consumer Function Interface Approach
        static Consumer<Customer> greetCustomerConsumer = customer ->
                System.out.println("Hello " + customer.customerName +
                        ", Thanks for registering the phone number " +
                        customer.customerPhoneNumber);

        // Normal Java Function Approach
        static void greetCustomer (Customer customer) {
            System.out.println("Hello " + customer.customerName +
                    ", Thanks for registering the phone number " +
                    customer.customerPhoneNumber);
        }
    }
}