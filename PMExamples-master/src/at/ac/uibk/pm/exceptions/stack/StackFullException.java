package at.ac.uibk.pm.exceptions.stack;

/**
 * Exception may be thrown if stack's capacity is reached and element is
 * requested to be pushed onto the stack.
 */
public class StackFullException extends StackException {
    private static final long serialVersionUID = 4577940194527108468L;

    /**
     * the number of elements already in the stack.
     */
    private final int elements;

    /**
     * the size of the stack.
     */
    private final int size;

    /**
     * Constructs a StackFullException.
     *
     * @param elements number of elements already in the stack
     * @param size size of the stack
     */
    public StackFullException(int elements, int size) {
        super(String.format("Expected a stack with less than %d elements but got stack with %d " +
                "elements.", size, elements));
        this.elements = elements;
        this.size = size;
    }

    /**
     * {@return the number of elements already in the stack}
     */
    public int getElements() {
        return elements;
    }

    /**
     * {@return the size of the stack}
     */
    public int getSize() {
        return size;
    }
}
