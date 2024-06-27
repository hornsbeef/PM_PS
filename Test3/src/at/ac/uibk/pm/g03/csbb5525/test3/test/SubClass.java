package at.ac.uibk.pm.g03.csbb5525.test3.test;

public class SubClass extends SuperClass {
    private final int factor;
    public int value = 3;

    public SubClass(int value, int factor) {
        super(value);
        this.factor = factor;
    }

    @Override
    public void setValue(int value) {
        super.setValue(factor * value);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", factor=" + factor;
    }
}