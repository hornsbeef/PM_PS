package at.ac.uibk.pm.exceptions.stack;

/**
 * @hidden
 */
public class StackApplication {

    private static final int MAX_ELEMENTS = 5;

    public static void main(String[] args) {
        Stack stack = new ArrayStack(MAX_ELEMENTS);
        try {
            stack.push(args);
        } catch (StackFullException e) {
            System.out.printf("Stack is full! Cannot handle more than %d elements.%n",
                    MAX_ELEMENTS);
            e.printStackTrace();
        }
    }
}