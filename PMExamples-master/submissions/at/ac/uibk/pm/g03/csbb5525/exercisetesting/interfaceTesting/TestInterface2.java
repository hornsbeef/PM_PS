package at.ac.uibk.pm.g03.csbb5525.exercisetesting.interfaceTesting;

public interface TestInterface2 extends TestInterface1 {

    void print2();

    @Override
    default void publicDefaultPrint() {
        System.out.println("This is the public DEFAULT print method of Interface 2 . \n" +
                                   "Trying to call: PrivateNONStaticPrint && privateStaticPrint " +
                                   "is NOT possible because they are private.");
        //privateNONStaticPrint();
        //privateStaticPrint();
        System.out.println("Now calling TestInterface1.super.publicDefaultPrint()");
        TestInterface1.super.publicDefaultPrint();
        //TestInterface2.super.publicDefaultPrint();

        System.out.println(CONSTANT);
    }
}
