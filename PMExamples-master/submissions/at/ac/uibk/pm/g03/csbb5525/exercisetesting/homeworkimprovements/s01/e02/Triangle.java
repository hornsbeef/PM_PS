package at.ac.uibk.pm.g03.csbb5525.exercisetesting.homeworkimprovements.s01.e02;

public class Triangle {

    enum signEnum {
        PLUS,
        MINUS
    }


    public static void main(String[] args) {
        int n = 10;
        if (n <= 0) {
            System.out.println("please use a reasonable n value...");
            System.exit(0);
        }

        signEnum mySignEnum = signEnum.MINUS;
        String sign;
        int counter = 0;


        //improvable mit Bedingungsoperator:
        //so als bsp: System.out.println(numberPrint % 2 == 0 ? " +" : " -");

        //improvable mit StringBuilder()

        //everything before n
        for (; counter < (n - 1); counter++) {
            sign = (counter % 2 == 0 ? " +" : " -");

            System.out.print("|");
            System.out.print(sign.repeat(counter));
            System.out.println(" " + (counter + 1) + ">");
        }

        {   //exactly n
            sign = (counter % 2 == 0 ? " +" : " -");

            System.out.print("|");
            System.out.print(sign.repeat(counter));
            System.out.println(" " + "n" + ">");
        }

        counter = n;
        //everything after n
        for (int nRepeatSign = n-2 ; nRepeatSign >= 0; nRepeatSign--, counter++) {
            sign = (counter % 2 == 0 ? " +" : " -");

            System.out.print("|");
            System.out.print(sign.repeat(nRepeatSign));
            System.out.println(" " + (counter + 1) + ">");
        }
    }

}
