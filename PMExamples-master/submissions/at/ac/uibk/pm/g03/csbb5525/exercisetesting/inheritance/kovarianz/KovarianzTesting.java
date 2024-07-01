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

        A newA = a.get();

        //B notWorking = a.get(); //why is this not working?
        //weil: a den Statischen Typ A hat, und bei der statischen Typprüfung
        // versucht wird der ReferenzVariable "B notworking" ein Objekt vom Typ A zuzuweisen, weil
        // hier noch nicht die dynamische Typprüfung gemacht wird, und in A die Methode get() den Typ A zurückgibt.

        //B newB = (B) a.get();

        if(a.get() instanceof B newB)   // ausgabe: get B
        {
            System.out.println("instanceof");
            B newNewB = newB.get(); // ausgabe: get B
        }


    }

}


