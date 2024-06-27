package at.ac.uibk.pm.g03.csbb5525.test3.test;

public class SuperClass {
    public int value;

    public SuperClass(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "value=" + value;
    }
}

