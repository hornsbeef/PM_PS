package at.ac.uibk.pm.g03.csbb5525.test3.test;

public class ToStringApplication {
    public static void main(String[] args) {
        SuperClass o1 = new SubClass(5, 2);
        System.out.println(o1);
        System.out.println(o1.value);

        SubClass o2 = (SubClass) o1;
        System.out.println(o2.value);
    }
}

