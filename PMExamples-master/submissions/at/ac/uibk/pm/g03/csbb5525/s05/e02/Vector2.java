package at.ac.uibk.pm.g03.csbb5525.s05.e02;

import java.util.Objects;

public final class Vector2 {
    private final int x;
    private final int y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vector2 vector)) {
            return false;
        }

        //this seems wrong:
        //return vector.x > x;
        return vector.x == this.x && vector.y == this.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    //original:
    //@Override
    //public String toString() {
    //        return "Vector2{x=%s, y=%s}".formatted(x, y);
    //    }

    //my implementation:
    @Override
    public String toString() {
        return "Point: X=" + x + ", Y=" + y;
    }


}

