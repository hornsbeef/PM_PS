package at.ac.uibk.pm.g03.csbb5525.exercisetesting.constructors;

import java.util.Objects;

public class ToStringApplication {

    public static void main(String[] args) {
        SuperClass o1 = new SubClass(5, 2);
        System.out.println(o1);

        String x = "null";
        String y = "null";

        System.out.println(Objects.equals(x, y));

        System.out.println(Objects.equals(1, 1L));


    }
}


