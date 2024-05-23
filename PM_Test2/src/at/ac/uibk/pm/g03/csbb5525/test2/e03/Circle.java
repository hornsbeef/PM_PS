package at.ac.uibk.pm.g03.csbb5525.test2.e03;

public class Circle extends AbstractShape{

    private final int radius;

    public Circle(String name, int radius){
        super(name);
        this.radius = radius;
    }


    @Override
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "name= " + this.getName() +
                " radius=" + radius +
                " circumference= " + getCircumference() +
                '}';
    }
}
