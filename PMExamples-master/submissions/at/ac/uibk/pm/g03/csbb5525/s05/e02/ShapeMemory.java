package at.ac.uibk.pm.g03.csbb5525.s05.e02;

public class ShapeMemory {
    private final Shape[] shapes;
    private int index = 0;

    public ShapeMemory(int size) {
        shapes = new Shape[size];
    }

    public void addElement(Shape shape) {
        if (index < shapes.length) {
            shapes[index++] = shape;
        }
    }

    public boolean contains(Shape shape) {
        for (Shape storedShape : shapes) {
            if (storedShape == null) {
                continue;
            }

            if (storedShape.equals(shape)) {
                return true;
            }
        }
        return false;
    }

}
