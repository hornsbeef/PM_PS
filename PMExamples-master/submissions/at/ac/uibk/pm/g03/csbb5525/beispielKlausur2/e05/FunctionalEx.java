package at.ac.uibk.pm.g03.csbb5525.beispielKlausur2.e05;

import java.util.HashMap;
import java.util.Map;

public class FunctionalEx {

    public static void main(String[] args) {
        Map<Integer, String> products = new HashMap<>();
        products.put(1, "Product 1");
        products.put(2, "Product 2");
        products.put(3, "Product 3");

        products.forEach((key, value) -> System.out.println(key + ": " + value));



    }





}
