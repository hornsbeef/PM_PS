package at.ac.uibk.pm.g03.csbb5525.s11.e02;

public class Main {

    public static void main(String[] args) {
        Container container1 = new Container();
        container1.add(new Item("a", 1));

        Container container2 = new Container();
        container2.add(container1);
        container2.add(new Item("b", 1));


        Container container3 = new Container();

        container2.add(container3);

        container3.add(new Item("c", 1));
        container3.add(new Item("c", 1));
        container3.add(new Item("c", 1));
        container3.add(new Item("c", 1));


        System.out.println(container2.calculateWeightInKg());

        container2.printCargo();

    }
}
