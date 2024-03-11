package at.ac.uibk.pm.innerclasses.memberclass;

/**
 * @hidden
 */
public class OuterClass {
    private String context = "OuterClass";

    /**
     * @hidden
     */
    public class InnerClass {
        private String context = "InnerClass";

        /**
         * @hidden
         */
        public class NestedInnerClass {
            private String context = "NestedInnerClass";

            public void print() {
                System.out.println(context);
                System.out.println(this.context);
                System.out.println(NestedInnerClass.this.context);
                System.out.println(InnerClass.this.context);
                System.out.println(OuterClass.this.context);
            }
        }
    }
}

