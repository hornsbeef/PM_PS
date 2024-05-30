package at.ac.uibk.pm.g03.csbb5525.s08.e02;

public class SortedTripleApplication {

    public static void main(String[] args) {

        SortedTriple<String> demo1 = new SortedTriple<>("ABasdf", "xyzasdf", "gtzurt");
        System.out.printf("%s < %s < %s\n", demo1.getFirst(), demo1.getSecond(), demo1.getThird());
        System.out.println(demo1);

    }

}
