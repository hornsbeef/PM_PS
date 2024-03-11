package at.ac.uibk.pm.testing.stack;

/**
 * Thrown by methods in the Stack class to indicate that the stack is full.
 */
public class FullStackException extends RuntimeException {
    private static final long serialVersionUID = 671798621126786871L;

    /**
     * Constructs a new {@code FullStackException}.
     */
    public FullStackException() {
    }
}
