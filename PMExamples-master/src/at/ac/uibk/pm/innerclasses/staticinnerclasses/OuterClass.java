package at.ac.uibk.pm.innerclasses.staticinnerclasses;

/**
 * @hidden
 */
public class OuterClass {
    private static int outerCount = 1;

    /**
     * @hidden
     */
    public static class StaticInnerClass {
        private static int innerCount = 3;

        public static void print() {
            System.out.println("counter sum: " + (innerCount + outerCount));
            ++outerCount;
            ++innerCount;
        }
    }
}

