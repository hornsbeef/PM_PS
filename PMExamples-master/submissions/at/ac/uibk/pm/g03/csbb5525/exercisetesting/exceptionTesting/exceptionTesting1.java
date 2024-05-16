package at.ac.uibk.pm.g03.csbb5525.exercisetesting.exceptionTesting;

import at.ac.uibk.pm.g03.csbb5525.s06.e03.PasswordIllegalException;

public class exceptionTesting1 {

    public static void main(String[] args) {

        assert(0 == 0) : "Assertions Test";

        try {
            //int x = 1/0;
            div(1,0);

        } catch(PasswordIllegalException pwE){
            System.out.println("PW_EXCEPT" + pwE.getMessage());
        }catch(ArithmeticException arithmeticException){
            System.out.println("Arit " + arithmeticException.getMessage());
        }
        catch (Exception e) {
            System.out.println("Exception");
        }
        //catch (ArithmeticException arithmeticException) {     //java: exception java.lang.ArithmeticException has already been caught
        //    System.out.println("arExcept");                   //because Exception is more general than ArithmeticException!
//}                                                             //needs to go form special -> general !


        try{
            exceptionTesting1 obj2 = new exceptionTesting1();
            obj2.realdiv(1,2,0);
        }catch(RuntimeException rte){
            System.out.println("RTX: "+ rte.getLocalizedMessage());
        }

    try {
        try {
            exceptionTesting1 obj2 = new exceptionTesting1();
            obj2.realdiv(1, 0);
        } catch (RuntimeException rte) {
            //throw new Exception("rethrow", rte);
            Exception exc = new Exception("rethrow Wrong: ");
            //exc.initCause(exc);
            exc.initCause(rte);
            throw exc;
        }
    }catch(Exception e){
        System.out.println("finalCatch " +e.getCause());
    }

    }

    public static int div(int one, int two) throws Exception {
        exceptionTesting1 obj = new exceptionTesting1();
        int x = obj.realdiv(one, two);
        return x;
    }

    public int realdiv(int x, int y) throws Exception {

        exTest2 test2 = new exTest2();
        test2.realdiv(y, x);

        if(y == 0){
            throw new PasswordIllegalException("not really a good usecase for this exception...");
        }

        return x/y;
    }

    public int realdiv(int x, int y, int z){

        if(z == 0){
            throw new ArrayIndexOutOfBoundsException("definitly not the right eXception");
        }
        return z;
    }


}


class exTest2 extends exceptionTesting1{

    @Override
    public int realdiv(int a, int b) throws RuntimeException//throws PasswordIllegalException
    {

        if(a ==0) {
            throw new ArithmeticException("test2");
            }
        return b/a;
    }

}