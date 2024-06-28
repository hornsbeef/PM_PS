package at.ac.uibk.pm.g03.csbb5525.exercisetesting.interfaceTesting;

public interface TestInterface1 {
    int CONSTANT = 17;  // public && static && final

    //private static final int CONTANT2 = 1;



    static void publicStaticPrint() //public && static
    {
        System.out.println("This is the Public Static Print Method of Interface 1 ." +
                                   "Now printing Constant: "+ CONSTANT);
    }

    private static void privateStaticPrint()    //private && static
    {
        System.out.println("This is the PRIVATE static print method of Interface 1 . " +
                                   "Now printing Constant: "+ CONSTANT);
    }

    ////////////////////////////////////////////////////////////////////////////////

    private void privateNONStaticPrint()
    {
        System.out.println("This is the PRIVATE NON-Static print method of Interface 1 . " +
                                   "Now printing Constant: " + CONSTANT);
    }

    /////////////////////////////////////////////////////////////////////////////////

    default void publicDefaultPrint(){
        System.out.println("This is the public DEFAULT print method of Interface 1 . " +
                                   "Calling: PrivateNONStaticPrint && privateStaticPrint");
        privateNONStaticPrint();
        privateStaticPrint();
    }

    void print();   //public && abstract


    abstract void xyz();




}
