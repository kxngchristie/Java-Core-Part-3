package practice.predicatebipredicateexample;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _PredicateBiPredict {

    static void main(String[] args) {
        // Java Function Approach
        System.out.println("\nWithout Predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("1200000000000"));
        System.out.println(isPhoneNumberValid("566700000000000"));
        System.out.println(isPhoneNumberValid("566700000000000"));

        // Predicate Function Approach
        System.out.println("\nWith Predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("1200000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("566700000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("566700000000000"));

        System.out.println("\nWith Chained Predicate");
        System.out.println(
                "Is Phone number valid and contains number 3 = " +
                isPhoneNumberValidPredicate.and(containsNumber3).test("1200000000000"));

        System.out.println(
                "Is Phone number valid and contains number 3 = " +
                        isPhoneNumberValidPredicate.and(containsNumber3).test("07345456788"));

        System.out.println(
                "Is Phone number valid or contains number 3 = " +
                        isPhoneNumberValidPredicate.or(containsNumber3).test("56345456788"));

        // BiPredicate Function Approach
        System.out.println("\nWith Chained BiPredicate");
        System.out.println(
                "Is Phone number valid and is the number 3 = " +
                        isNumber3BiPredicateImpl.and(isNumber3).test("07345456788", 3));
    }

    // BiPredicate Function Approach
    static BiPredicate<String, Integer> isNumber3BiPredicateImpl = (phoneNumber, number) ->
            phoneNumber.startsWith("07");

    static BiPredicate<String, Integer> isNumber3 = (phoneNumber, number) ->
            number == 3;

    // Predicate Function Approach
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber  ->
            phoneNumber.contains("3");

    // Java Function Approach
    static boolean isPhoneNumberValid (String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }
}