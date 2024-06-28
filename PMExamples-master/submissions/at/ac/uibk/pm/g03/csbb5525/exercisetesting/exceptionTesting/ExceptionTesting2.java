package at.ac.uibk.pm.g03.csbb5525.exercisetesting.exceptionTesting;

public class ExceptionTesting2 {


    class MyException extends RuntimeException{

        public MyException(String info){
            super(info);
        }
    }

    public void foo() {
        throw new MyException("myexception");
    }



    public static void main(String[] args) {

        try {

            try {
                int x = 2 / 0;

            } finally {
                System.out.println("just in finally");
            }


        } catch (Exception e) {
            System.out.println("in outer catch");
        }
        //catch(RuntimeException rte)    //error because MUST be Special --> General
        //{
        //    System.out.println("");
        //}

        new ExceptionTesting2().foo();


    }
}


