package at.ac.uibk.pm.g03.csbb5525.exercisetesting.generics;

import java.util.*;

public class GenericTestClass {

    public static void append(List<Vehicle> source, List<Vehicle> target) {
        for (Vehicle element : source) {
            target.add(element);
        }
    }

    public static <T extends Vehicle> void append2(List<T> source, List<? super T> target){
        for (T element : source) {
            target.add(element);
        }
    }



    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        List<Truck> trucks = new ArrayList<>();
        //append(trucks, vehicles); // Compile-Error!
        append2(trucks, trucks);

        
    }




}
