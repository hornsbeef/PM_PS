package at.ac.uibk.pm.innerclasses.memberclass;

/**
 * @hidden
 */
public final class InnerClassApplication {
    public static void main(final String[] args) {
        final Outer outer = new Outer();
        outer.createAndPrintInner("Inner");
    }
}
