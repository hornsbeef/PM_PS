package at.ac.uibk.pm.g03.csbb5525.test2.e03;

public abstract class AbstractShape implements Shape{

    private final String name;

    public AbstractShape(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
