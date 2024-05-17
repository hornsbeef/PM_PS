package at.ac.uibk.pm.g03.csbb5525.exercisetesting.wrapperClassTesting;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {

        Byte b = 1;
        Short s = 2;
        Integer i = 3;
        Long l = 3L;
        Float f = 3.5F;
        Double d = 3.7;


        Boolean bo = true;
        Character c = 'c';

        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(bo);
        System.out.println(c);

        String str = "122";
        System.out.println(1 + parseInt(str));

        System.out.println(Double.compare(d, 3.7) == 0);
        System.out.println(d == 3.7);



    }
}
