package at.ac.uibk.pm.g03.csbb5525.test2.e03;

public class Square extends AbstractShape{

    private final int sideLength;

    public Square(String name, int sideLength){
        super(name);
        this.sideLength = sideLength;
    }


    @Override
    public double getCircumference() {
        return 4 * sideLength;
    }

    @Override
    public String toString() {
        return "Square{" +
                "name= " + this.getName() +
                " sideLength=" + sideLength +
                " circumference= " + getCircumference() +
                '}';
    }
}
