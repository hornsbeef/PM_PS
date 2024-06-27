package at.ac.uibk.pm.g03.csbb5525.test3.e03;

public class Test2 extends Test{
    public static String FOO = "asdf";
    public static void main(String[] args) {
        System.out.println(FOO);
        //System.out.println(Test.FOO);
    }

    private void bar() {
        System.out.println(FOO);
        System.out.println(super.FOO);
    }
}
