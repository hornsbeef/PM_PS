package at.ac.uibk.pm.g03.csbb5525.exercisetesting.constructors;

public class SubClass extends SuperClass {
    private final int factor;
    //private Member werden nicht vererbt -> hat keinen Member value.

    public SubClass(int value, int factor) {
        super(value);
        System.out.println("Constructor in SubClass");
        this.factor = factor;
        //this.value = value; nicht mal möglich!
    }

    @Override
    public void setValue(int value) {
        System.out.println("setValue In SubClass");
        super.setValue(factor * value); //HERE: factor is still 0
                                        // because it has not been initialized!
    }

    @Override
    public String toString() {
        System.out.println("toString in SubClass; "
                                   //+ "Subclass.value= " + value //nicht möglich!!
        );
        return super.toString() + ", factor=" + factor;
    }
}
