package at.ac.uibk.pm.g03.csbb5525.exercisetesting._uglyTesting;

public class UglyTesting2<T> {

    private T someType;

    public UglyTesting2(T someType){
        this.someType = someType;
    }

    public void methodA(){
        System.out.println(someType.toString());
        System.out.println(someType);

    }


    public static void main(String[] args) {

    }
}
