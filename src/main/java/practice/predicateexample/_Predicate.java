package practice.predicateexample;

import java.util.function.Predicate;

public class _Predicate {

    static void main(String[] args) {
        // Java Function Approach
        System.out.println("\nWithout Predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("1200000000000"));
        System.out.println(isPhoneNumberValid("566700000000000"));
        System.out.println(isPhoneNumberValid("566700000000000"));

        //Predicate Function Approach
        System.out.println("\nWith predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("1200000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("566700000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("566700000000000"));
    }

    // Java Function Approach
    static boolean isPhoneNumberValid (String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    //Predicate Function Approach
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;
}