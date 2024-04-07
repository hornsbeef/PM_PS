package at.ac.uibk.pm.g03.csbb5525.exercisetesting;

public class s01e01 {
    public static void main(String[] args) {
        System.out.println( (short)10);
        System.out.println("a)  5 * 7 / 3 = " + 5 * 7 / 3);
        System.out.println("b)  1 << 8 % 3 = " + (1 << 8 % 3) );
        System.out.println("c)  (short)Integer.MAX_VALUE = " + (short)(Integer.MAX_VALUE) );
        //System.out.println(Integer.MAX_VALUE / Short.MAX_VALUE );
        //System.out.println(Integer.MAX_VALUE % Short.MAX_VALUE );

        /*
        System.out.println("c_1) Integer.MAX_VALUE = " + Integer.MAX_VALUE + "; Short.MAX_VALUE = "+ Short.MAX_VALUE);
        System.out.println("     Int_max / Short_max = " + Integer.MAX_VALUE / Short.MAX_VALUE);
        System.out.println(" 65538 * Short_max = " + 65538 * Short.MAX_VALUE);
        System.out.println(" Int_max - (65538 * Short_max) = " + ((Integer.MAX_VALUE) - 65538 * Short.MAX_VALUE) );


         */
        /*
        short result = 0;
        for(int runner = Integer.MAX_VALUE; runner > 1; runner -= Short.MAX_VALUE){
            result += Short.MAX_VALUE;
            //System.out.println(result);
        }
        result += Integer.MAX_VALUE % Short.MAX_VALUE;
        System.out.println(result);
        */



        System.out.println("d) 23 / (double) 11 = " + 23 / (double) 11);
        System.out.println("e) (double) (23/11) = " + (double) (23/11));
        System.out.println("f) 42f = " + 42f );
        System.out.println("g) 4e3D = "+ 4e3D);
        boolean floatEqualToDouble = 0.1f == 0.1;
        System.out.println("h) 0.1f == 0.1 = " + floatEqualToDouble);
        System.out.println("i) 1 == 24 % 3 && 4 > 7 || true = " + (1 == 24 % 3 && 4 > 7 || true));
        System.out.println("j) 1 == 24 % 3 ? 4 : 7 = " + (1 == 24 % 3 ? 4 : 7));


    }


}
