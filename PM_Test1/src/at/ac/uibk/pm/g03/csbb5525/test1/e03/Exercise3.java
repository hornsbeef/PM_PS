package at.ac.uibk.pm.g03.csbb5525.test1.e03;

public class Exercise3 {

    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {
            System.out.println("line" + i);
            printShape(i);
            System.out.println("\n\n");
        }
        printShape(10);
        printShape(0);
        printShape(Integer.MAX_VALUE);


    }

    public static void printShape(int n) {
        if (n < 1 || n > 9) {
            return;
        } else {

            int lineWidthWithoutNumber = (2 * n - 3);
            int lineNumber = 1;
            String space = " ";

            for (; lineNumber < n; lineNumber++) {

                System.out.print(space.repeat(lineNumber - 1));
                System.out.print(lineNumber);

                int j = lineNumber;
                for (int i = lineWidthWithoutNumber; i >= 1; i--) {
                    String sign = (j % 2 == 0) ? "+" : "|";
                    System.out.print(sign);
                    j--;
                }
                lineWidthWithoutNumber -= 2;

                System.out.println(lineNumber);

            }

            System.out.print(space.repeat(lineNumber - 1));
            System.out.println(lineNumber);


        }
    }
}
