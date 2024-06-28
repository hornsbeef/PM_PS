package at.ac.uibk.pm.g03.csbb5525.exercisetesting.inheritance.StaticBindung1;

public class StaticBinding {

}

class Animal {
    static void makeSound() {
        System.out.println("Animal makes a sound");
    }

}

class Dog extends Animal {
    static void makeSound() {
        System.out.println("Dog barks");
    }
}

class Main {
    public static void main(String[] args) {
        Animal.makeSound(); // Ausgabe: "Animal makes a sound"
        Dog.makeSound();    // Ausgabe: "Dog barks"


        Animal animal = new Dog();// Ausgabe: "Animal makes a sound"
        animal.makeSound();

        Dog dogAnimal = (Dog) animal;
        dogAnimal.makeSound();  // Ausgabe: "Dog barks"


    }
}