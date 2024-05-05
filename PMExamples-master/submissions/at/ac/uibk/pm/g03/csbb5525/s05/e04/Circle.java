package at.ac.uibk.pm.g03.csbb5525.s05.e04;

import codedraw.CodeDraw;

import java.util.Objects;

public class Circle {
    private final int radius;
    private final int xCoordinate;
    private final int yCoordinate;

    public Circle(int radius, int xCoordinate, int yCoordinate) {
        this.radius = radius;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public void draw(CodeDraw cd){
        cd.drawCircle(xCoordinate, yCoordinate, radius);
        System.out.println(this.toString());

    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle circle)) return false;
        return radius == circle.radius && xCoordinate == circle.xCoordinate && yCoordinate == circle.yCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, xCoordinate, yCoordinate);
    }
}
