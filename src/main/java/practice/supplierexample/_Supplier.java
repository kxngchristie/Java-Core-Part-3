package practice.supplierexample;

import java.util.function.Supplier;

public class _Supplier {

    static void main(String[] args) {
        // Java Function Approach
        System.out.println(getDBConnectionUrl());

        // Supplier Function Approach
        System.out.println(getDbConnectionUrlSupplier.get());
    }

    // Java Function Approach
    static String getDBConnectionUrl () {
        return "jdbc://localhost:5432/users";
    }

    // Supplier Function Approach
    static Supplier<String> getDbConnectionUrlSupplier = () ->
            "jdbc://localhost:5432/users";
}