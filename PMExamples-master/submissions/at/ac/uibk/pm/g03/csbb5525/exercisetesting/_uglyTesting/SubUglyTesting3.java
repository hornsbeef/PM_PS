package at.ac.uibk.pm.g03.csbb5525.exercisetesting._uglyTesting;

//public class SubUglyTesting3<T> extends UglyTesting3<String>{
public class SubUglyTesting3<T> implements UglyTesting3<String>{

    /*
    'foo(T)' in 'at.ac.uibk.pm.g03.csbb5525.exercisetesting._uglyTesting.SubUglyTesting3'
    clashes with
    'foo(T)' in 'at.ac.uibk.pm.g03.csbb5525.exercisetesting._uglyTesting.UglyTesting3';
    both methods have same erasure, yet neither overrides the other
     */
    //Same problem with Interface of Class
    //public void foo(T p1)
    //{
    //    System.out.println("something");
    //}

    @Override
    public void foo(String p1){
        System.out.println("something");
    }


    //public static void methodX(){
    public void methodX(){

        class LocalInnerClass{
            private int i = 19 ;
            public int b = 1;
            public static int x = 3;
            static int asdf = 5;

            public static void LocInnerClassMethod(){
                System.out.println("why does this work???");
            }
        }

        var z = new LocalInnerClass().x;
        System.out.println(z);
        //System.out.println(b);
        LocalInnerClass.LocInnerClassMethod();

    }

    public static void main(String[] args) {
        new SubUglyTesting3<String>().methodX();
    }



}
