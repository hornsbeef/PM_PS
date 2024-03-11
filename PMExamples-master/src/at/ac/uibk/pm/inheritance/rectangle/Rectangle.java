package at.ac.uibk.pm.inheritance.rectangle;

import java.util.Objects;

/**
 * A representation of a 2D rectangle.
 */
public class Rectangle {

    private int width;
    private int length;

    /**
     * Constructs a rectangle with given length and width.
     *
     * @param width  of rectangle to be created.
     * @param length of rectangle to be created.
     */
    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    /**
     * Constructs a rectangle with the same side length for all sides.
     *
     * @param sideLength of rectangle to be created.
     */
    public Rectangle(int sideLength) {
        this(sideLength, sideLength);
    }

    /**
     * Constructs a rectangle.
     */
    public Rectangle() {
    }

    /**
     * Returns width of rectangle.
     *
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets width of rectangle.
     *
     * @param width Width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Returns length of rectangle.
     *
     * @return length
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets length of rectangle.
     *
     * @param length Length
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Returns computed area for rectangle.
     *
     * @return area
     */
    public int getArea() {
        return width * length;
    }

    @Override
    public String toString() {
        return "Rectangle{" + "width=" + width + ", length=" + length + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle rectangle)) return false;
        return width == rectangle.width && length == rectangle.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, length);
    }
}
