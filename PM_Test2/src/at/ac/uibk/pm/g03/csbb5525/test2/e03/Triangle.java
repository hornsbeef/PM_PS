package at.ac.uibk.pm.g03.csbb5525.test2.e03;

public class Triangle extends AbstractShape{

    private final int sideLength;

    public Triangle(String name, int sideLength){
        super(name);
        this.sideLength = sideLength;
    }

    @Override
    public double getCircumference() {
        return 3 * sideLength;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "name= " + this.getName() +
                " sideLength=" + sideLength +
                " circumference= " + getCircumference() +
                '}';
    }
}
