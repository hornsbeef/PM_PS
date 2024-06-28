package at.ac.uibk.pm.g03.csbb5525.exercisetesting.interfaceTesting;

public abstract class AbstractTestClass {

    private int x;

    public AbstractTestClass(){
        x = 1;
    }

    void print(){
        System.out.println("not abstract");
    }

    abstract void foo();

    //default abstract void bar(){
    //    System.out.println("");
    //}


}
