package at.ac.uibk.pm.generics.point;

/**
 * Class representing a point on a plane.
 * @param <T> Type of the coordinates
 */
public final class Point<T> {
    private final T x;
    private final T y;

    /**
     * Constructs a point with the given x and y coordinates.
     *
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public Point(T x, T y) {
        this.x = x;
        this.y = y;
    }

    /**
     * {@return the x-coordinate's value}
     */
    public T getX() {
        return x;
    }

    /**
     * {@return the y-coordinate's value}
     */
    public T getY() {
        return y;
    }
}

