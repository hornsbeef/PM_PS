package at.ac.uibk.pm.g03.csbb5525.exercisetesting.enumExperiment;

import at.ac.uibk.pm.g03.csbb5525.exercisetesting.enumExperiment.Experiment;

import java.util.Arrays;

import static at.ac.uibk.pm.g03.csbb5525.exercisetesting.enumExperiment.Experiment.*;

public class EnumExperiment {

    public static void main(String[] args) {
        Experiment experiment = RED;
        System.out.println(experiment.getValue());
        System.out.println(experiment.getString());

        experiment.setString("I changed the string");
        System.out.println(experiment.getString());

        Experiment ex2 = RED;
        System.out.println(ex2.getString());

        System.out.println(RED.getString());


        System.out.println(RED.name());
        System.out.println(RED.ordinal());
        System.out.println(RED.toString());

        System.out.println("-".repeat(20));
        Arrays.stream(RED.values()).forEach(System.out::println);
        System.out.println("-".repeat(20));
        Arrays.stream(Experiment.values()).forEach(x -> {
            System.out.println(x.name());
            System.out.println(x.ordinal());

            System.out.println(x.toString());
        });

    }

}

enum Experiment{
    RED(1, "asdf"), GREEN(2, "hohoho"), BLUE(3, "xyz");
    private int value = 0;
    private String string;
    //private Experiment exp;

    Experiment(int value, String string){
        this.value = value;
        this.string = string;
        //this.exp = new Experiment(value, string); //Enum types cannot be instantiated
    }

    public String getString() {
        return string;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setString(String string) {
        this.string = string;
    }
}
