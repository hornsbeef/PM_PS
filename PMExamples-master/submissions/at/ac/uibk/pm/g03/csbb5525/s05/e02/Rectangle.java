package at.ac.uibk.pm.g03.csbb5525.s05.e02;

import codedraw.CodeDraw;

import java.util.Objects;
public class Rectangle extends Shape {
    private final Vector2 size;

    public Rectangle(Vector2 start, Vector2 size) {
        super(start);
        this.size = size;
    }

    @Override
    public void draw(CodeDraw cd) {
        cd.drawRectangle(getStart().getX(), getStart().getY(), size.getX(), size.getY());
    }

    public Vector2 getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rectangle rectangle)) {
            return false;
        }
        return getStart().equals(rectangle.getStart()) && size.equals(rectangle.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStart(), size);
    }

    //added by me:
    @Override
    public String toString() {
        //this approach is used, so that the user is not overwhelmed by double values and decimal places,
        //while still being able to use double for the actual drawing.
        return "Rectangle {" +
                "x1=" +Math.round(getStart().getX()) +','+
                "y1="+Math.round(getStart().getY()) +','+
                "width=" + Math.round(size.getX()) + ',' +
                "height=" + Math.round(size.getY()) + '}';
    }
}
