package at.ac.uibk.pm.g03.csbb5525.exercisetesting.interfaceTesting;

public class TestClass implements TestInterface2, TestInterface3{

    //default void foo(){
    //    System.out.println("");
    //}
    //

    protected Number bar(){
        return  Integer.valueOf("1");
    }


    private void methodC(){
        System.out.println("");
    }

    public TestClass(){
        super();
    }


    @Override
    public void print2() {

        System.out.println("Implementation of print2 from Interface 2.");
    }

    @Override
    public void print() {
        System.out.println("Implementation of print from Interface 1.");
    }

    @Override
    public void xyz() {
        //ignore
    }

    //is needed because intherits default from Interface2 and interface3
    @Override
    public void publicDefaultPrint()
    {
        TestInterface2.super.publicDefaultPrint();
    }

    public final void foo(){
        System.out.println(this.getClass());
    }


    @Override
    public String toString() {
        return this.getClass().toString();
    }

    public static void main(String[] args) {
        TestClass tc = new TestClass();

        tc.print();
        tc.print2();
        tc.publicDefaultPrint();

        System.out.println("-".repeat(23));
        System.out.println("Printing CONSTANT of Interface 1: " +tc.CONSTANT) ;

        System.out.println("-".repeat(23));

        TestInterface1 tI1 = new TestClass();
        //tI1.publicStaticPrint(); //not working like that
        TestInterface1.publicStaticPrint();

        //TestInterface1.privateNONStaticPrint();
        //TestInterface1.privateStaticPrint();

        TestInterface2 tI2 = new TestClass();
        System.out.println(TestInterface2.CONSTANT);
        tI2.publicDefaultPrint();

        System.out.println("#".repeat(20));


        //TestInterface2.publicDefaultPrint();
        tI2.publicDefaultPrint();


        TestClass2 testClass2 = new TestClass2();

        testClass2.print();

        System.out.println("#".repeat(20));

        tc.foo();
        testClass2.foo();

        System.out.println("#".repeat(20));
        System.out.println("#".repeat(20));


        System.out.println(tc.toString());
        System.out.println(testClass2.toString());


    }

}
