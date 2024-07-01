package at.ac.uibk.pm.g03.csbb5525.s11.e02;

import java.util.ArrayList;
import java.util.List;

public class Container implements Cargo{


    List<Container> list = new ArrayList<>();

    public <T extends Container> void add(T thing){
        list.add(thing);
    }

    @Override
    public int calculateWeightInKg() {
        return list.stream().map(it -> it.calculateWeightInKg()).reduce(Integer::sum).orElse(0);
    }

    @Override
    public void printCargo() {

        List<String> stringList = list.stream()
                               .map(it -> it.getCargo())
                               .toList();

        System.out.println(String.join(", ", stringList));



    }

    public String getCargo(){
        List <String> stringList = list.stream().map(it -> it.getCargo()).toList();
        return String.join(", ", stringList);
    }

}
