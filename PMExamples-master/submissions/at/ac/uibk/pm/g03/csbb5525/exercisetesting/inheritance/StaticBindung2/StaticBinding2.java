package at.ac.uibk.pm.g03.csbb5525.exercisetesting.inheritance.StaticBindung2;

public class StaticBinding2 {
}


class Animal {
    Animal() {
        System.out.println("Animal constructor");
    }
}

class Dog extends Animal {
    Dog() {
        System.out.println("Dog constructor");
    }
}

class Main {
    public static void main(String[] args) {
        Animal animal = new Animal(); // Ausgabe: "Animal constructor"

        System.out.println("-".repeat(20));

        Dog dog = new Dog(); // Ausgabe: "Animal constructor" gefolgt von "Dog constructor"

        System.out.println("-".repeat(20));

        Animal dogAnimal = new Dog();   // Ausgabe: "Animal constructor" gefolgt von "Dog constructor"


    }
}
