package at.ac.uibk.pm.g03.csbb5525.s11.e02;

public class Item extends Container implements Cargo {

    private String name;
    private int weight;

    public Item(String name, int weight){
        this.name = name;
        this.weight = weight;
    }



    @Override
    public int calculateWeightInKg() {
        return weight;
    }

    @Override
    public void printCargo() {
        System.out.println(name);
    }

    @Override
    public String getCargo(){
        return name;
    }
}
