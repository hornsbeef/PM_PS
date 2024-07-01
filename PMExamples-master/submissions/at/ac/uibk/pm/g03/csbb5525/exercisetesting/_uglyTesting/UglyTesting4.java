package at.ac.uibk.pm.g03.csbb5525.exercisetesting._uglyTesting;

interface TestInterface{
    void myTestInterfaceMethod();
}

public class UglyTesting4 {

    public void methodForLocalInnerClass(){
        System.out.println("Starting methodForLocalInnerClass ");

        int outerX = 1;
        outerX++;

        class LocalInnerClass{
            private int i = 19 ;
            public int b = 1;

            //Warum kann ich in einer LocalInnerClass eine STATIC non-final Variable definieren?
            public static int x = 3;
            private static int asdf = 5;

            public void LocalInnerMethod2(){
                //System.out.println(outerX); //not working as expected!
                //Variable 'outerX' is accessed from within inner class, needs to be final or effectively final
            }

            public static void LocalInnerClassMethod(){
                System.out.println("why can I create a STATIC method in a Local Inner Class? ");
                x++;
                asdf++;
            }

            LocalInnerClass X = new LocalInnerClass(){
                public void myMethod(){
                    System.out.println("anonymous?");
                }
            };
            //X.myMethod();
            //X.LocalInnerMethod2();

            TestInterface myTestInterface = new TestInterface() {
                @Override
                public void myTestInterfaceMethod() {
                    System.out.println("declared in Interface");
                }

               public void newMethod(){
                   System.out.println("newly defined Method");
               }
            };

            //myTestInterface.myTestInterfaceMethod();


        }
        var z = new LocalInnerClass().x;
        System.out.println("static localInnerClass x = " +z);

        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.x++;


        System.out.println("static localInnerClass x = " + new LocalInnerClass().x);

        //System.out.println(b);
        LocalInnerClass.LocalInnerClassMethod();

        System.out.println("static localInnerClass x = " + new LocalInnerClass().x);

        System.out.println("private static LocalInnerClass.asdf"+LocalInnerClass.asdf);

        System.out.println("private int i: "+ new LocalInnerClass().i);
    }

    public void methodWithoutLocalInnerClass(){
        //var x = new LocalInnerClass();    //not working, as expected.
    }

    public static void main(String[] args) {
        new UglyTesting4().methodForLocalInnerClass();
    }

}
