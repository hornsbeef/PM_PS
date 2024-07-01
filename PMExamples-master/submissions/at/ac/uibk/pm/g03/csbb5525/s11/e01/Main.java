package at.ac.uibk.pm.g03.csbb5525.s11.e01;

public class Main {

    public static void main(String[] args) {
        UserConfig one = new UserConfig(1234, "asdf");
        UserConfig two = new UserConfig(1234, "asdf");

        System.out.println(one.groupNumber());
        System.out.println(one.userName());
        System.out.println(one.hashCode());

        System.out.println(one.equals(two));



    }






}
