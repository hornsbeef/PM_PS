package at.ac.uibk.pm.g03.csbb5525.s05.e02;

import codedraw.CodeDraw;

abstract public class Shape {
    private final Vector2 start;
    public Shape(Vector2 start) {
        this.start = start;
    }

    public abstract void draw(CodeDraw cd);

    public Vector2 getStart() {
        return start;
    }



}
