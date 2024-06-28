package at.ac.uibk.pm.g03.csbb5525.exercisetesting.inheritance.kovarianz;

class A{

    public A get(){
        System.out.println("get A");
        return new A();
    }
}

class B extends A{

    @Override
    public B get(){
        System.out.println("get B");
        return new B();
    }
}

public class KovarianzTesting {

    public static void main(String[] args) {
        A a = new B();

        a.get();    // ausgabe: get B

        //A newA = a.get();

        //B notWorking = a.get(); //why is this not working?

        //B newB = (B) a.get();

        if(a.get() instanceof B newB)   // ausgabe: get B
        {
            System.out.println("instanceof");
            B newNewB = newB.get(); // ausgabe: get B
        }


    }

}


