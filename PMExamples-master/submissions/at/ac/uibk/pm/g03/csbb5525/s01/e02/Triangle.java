package at.ac.uibk.pm.g03.csbb5525.s01.e02;

public class Triangle {

    enum signEnum {
        PLUS,
        MINUS
    }


    public static void main(String[] args) {
        int n = 20;
        if (n <= 0){
            System.out.println("please use a reasonable n value...");
            System.exit(0);
        }

        signEnum mySignEnum = signEnum.MINUS;
        String sign;
        int counter = 0;

        for(; counter < (n-1); counter++){
            sign = printSign(mySignEnum);
            mySignEnum = changeEnum(mySignEnum);

            System.out.print("|");
            System.out.print(sign.repeat(counter));
            System.out.println(" " + (counter + 1) + ">");
        }

        {
            sign = printSign(mySignEnum);
            mySignEnum = changeEnum(mySignEnum);

            System.out.print("|");
            System.out.print(sign.repeat(counter));
            System.out.println(" " + "n" + ">");
        }

        counter = n ;
        for(int runner = n-2; runner >= 0; runner--, counter++){
                sign = printSign(mySignEnum);
                mySignEnum = changeEnum(mySignEnum);

                System.out.print("|");
                System.out.print(sign.repeat(runner));
                System.out.println(" " + (counter + 1) + ">");
        }
    }

    static String printSign(signEnum myPrintSign){
        switch (myPrintSign){
            case PLUS -> {return " +";}
            case MINUS -> {return " -";}
            default -> {return "something went horribly wrong ";}
        }
    }

    static signEnum changeEnum(signEnum myPrintSign){
        switch (myPrintSign){
            case PLUS -> {return signEnum.MINUS;}
            case MINUS -> {return signEnum.PLUS;}
            default -> {System.out.println("something went horribly wrong"); System.exit(1);return signEnum.MINUS; }
        }
    }

}
