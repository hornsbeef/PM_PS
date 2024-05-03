package at.ac.uibk.pm.g03.csbb5525.s05.e02;


import codedraw.CodeDraw;

import java.util.Objects;

public class Line extends Shape {
    private final Vector2 end;

    public Line(Vector2 start, Vector2 end) {
        super(start);
        this.end = end;
    }

    @Override
    public void draw(CodeDraw cd) {
        cd.drawLine(getStart().getX(), getStart().getY(), end.getX(), end.getY());
    }

    public Vector2 getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Line line)) {
            return false;
        }
        //original
        return getStart().equals(line.getStart()) && end.equals(line.end);
        //just me testing:
        //return getStart().equals(line.getStart()) && getEnd().equals(line.getEnd());

    }

    @Override
    public int hashCode() {
        return Objects.hash(end);
    }

    //added by me:
    @Override
    public String toString() {
        //this approach is used, so that the user is not overwhelmed by double values and decimal places,
        //while still being able to use double for the actual drawing.
        return "Line{" +
                "x1=" + Math.round(getStart().getX()) + "," +
                "y1=" + Math.round(getStart().getY()) + "," +
                "x2=" + Math.round(end.getX()) + "," +
                "y2=" + Math.round(end.getY()) +
                "}";
    }
}
