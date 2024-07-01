package at.ac.uibk.pm.g03.csbb5525.beispielKlausur2.e04;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DataStore<T extends Number> {

    private List<T> numberList = new ArrayList<>();

    public void setNumber(T input){
        numberList.add(input);
    }

    public T getNumber(int index){
        try{
            return numberList.get(index);
        }catch(IndexOutOfBoundsException indexOutOfBoundsException){
            System.out.println("Index is out of Bounds! ");
            var ex = new NoSuchElementException();
            throw ex;
        }
        //return null;
    }


    public static void main(String[] args) {
        DataStore<Integer> store = new DataStore<>();

        store.setNumber(0);
        store.setNumber(1);
        store.setNumber(2);
        store.setNumber(3);

        System.out.println(store.getNumber(0));
        System.out.println(store.getNumber(1));
        System.out.println(store.getNumber(2));
        System.out.println(store.getNumber(3));
        //System.out.println(store.getNumber(4));

    }


}
