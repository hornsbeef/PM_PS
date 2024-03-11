package at.ac.uibk.pm.innerclasses.memberclass;

/**
 * @hidden
 */
public class NestedInnerClassesApplication {
    public static void main(String[] args) {
        new OuterClass().new InnerClass().new NestedInnerClass().print();
    }
}

