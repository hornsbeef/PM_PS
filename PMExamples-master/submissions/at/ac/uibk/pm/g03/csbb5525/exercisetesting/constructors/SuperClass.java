package at.ac.uibk.pm.g03.csbb5525.exercisetesting.constructors;

public class SuperClass {
    private int value;

    public SuperClass(int value) {
        System.out.println("Constructor in Super");
        setValue(value);
    }

    public void setValue(int value) {
        System.out.println("setValue In Super");
        this.value = value;
    }

    @Override
    public String toString() {
        System.out.println("toString in Super = " + value);
        return "value=" + value;
    }
}

