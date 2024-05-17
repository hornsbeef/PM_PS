package at.ac.uibk.pm.g03.csbb5525.exercisetesting.equals_experiment;

public class Main {
    public static void main(String[] args) {
        EqualsExperiment eq = new EqualsExperiment("test");
        EqualsExperiment eq2 = new EqualsExperiment("test222");

        System.out.println(eq.equals(eq2));
        System.out.println(eq.hashCode());
        System.out.println(eq2.hashCode());

        System.out.println("-".repeat(20));

        EqualsExperiment eq3 = eq.clone();

        System.out.println(eq.equals(eq3));
        System.out.println(eq.hashCode());
        System.out.println(eq3.hashCode());

        System.out.println("-".repeat(20));

        EqualsExperiment eq4 = new EqualsExperiment(eq2);
        System.out.println(eq4.equals(eq2));
        System.out.println(eq4.hashCode());
        System.out.println(eq2.hashCode());

    }
}
