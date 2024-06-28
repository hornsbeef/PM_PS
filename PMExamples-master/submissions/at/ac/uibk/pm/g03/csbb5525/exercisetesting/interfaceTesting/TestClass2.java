package at.ac.uibk.pm.g03.csbb5525.exercisetesting.interfaceTesting;

public class TestClass2 extends TestClass{

    void test(){
        System.out.println("Test");
    }

    public interface xyz{
        void drive();
    }

    public class somethin{

    }

    public void fooUser(){
        new TestClass().foo();
    }

    @Override
    public void print() {
        super.print();
    }

    //public void foo(){
    //    System.out.println("New implementation");
    //}

    void methodC(){

    }


    @Override
    protected Integer bar() {
        return Integer.valueOf("2");
    }
}

