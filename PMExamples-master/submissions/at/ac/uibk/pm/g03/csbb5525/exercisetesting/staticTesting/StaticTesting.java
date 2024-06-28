package at.ac.uibk.pm.g03.csbb5525.exercisetesting.staticTesting;

public class StaticTesting {

    private static double x;
    private int y;

    public StaticTesting(){
        x=3;
        y=1;
        this.y = 2;
        foo();
        bar();
    }

    public static void foo(){
        x=3;
        //y=1;
        //this.y = 2;
        foo();
        //bar();



    }

    public void bar() {
        x=3;
        y=1;
        this.y = 2;
        foo();
        bar();
    }



}
