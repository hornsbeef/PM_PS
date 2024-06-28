package at.ac.uibk.pm.g03.csbb5525.exercisetesting.inheritance.StaticBindung3;

public class StaticBindung3 {
}


class Animal {
    public int age = 5;
}

class Dog extends Animal {
    public int age = 10;

    void print(){
        System.out.println("Dog printing age: "+ age);
    }

}

class Main {
    public static void main(String[] args) {

        Animal animal = new Animal();
        System.out.println(animal.age); // Ausgabe: 5 (statischer Typ von animal ist Animal)
        //animal.print();


        System.out.println("-".repeat(20));

        Animal dogAnimal = new Dog();
        System.out.println(dogAnimal.age); // Ausgabe: 5 (statischer Typ von dogAnimal ist Animal)


        System.out.println("-".repeat(20));

        Dog dog = new Dog();
        System.out.println(dog.age); // Ausgabe: 10 (statischer Typ von dog ist Dog)

    }
}

