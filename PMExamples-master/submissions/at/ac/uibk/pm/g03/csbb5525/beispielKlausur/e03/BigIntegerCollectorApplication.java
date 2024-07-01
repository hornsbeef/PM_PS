package at.ac.uibk.pm.g03.csbb5525.beispielKlausur.e03;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BigIntegerCollectorApplication {

    public static void main(String[] args) {
        List<BigInteger> values =
                List.of(BigInteger.TEN, BigInteger.valueOf(5), BigInteger.valueOf(30));


        Optional<BigInteger> maxDifference = values
                .stream()
                .collect(BigIntegerCollector.maxDifference());

        System.out.println(maxDifference);

        System.out.println("+".repeat(23));

        List<BigInteger> newList = new ArrayList<>();

        newList.add(null);
        newList.addAll(values);

        Optional<BigInteger> newMaxDifference = newList
                .stream()
                .collect(BigIntegerCollector.maxDifference());

        System.out.println(newMaxDifference);

        System.out.println("+".repeat(23));

        List<BigInteger> nextList = new ArrayList<>();

        Optional<BigInteger> nextnewMaxDifference = nextList
                .stream()
                .collect(BigIntegerCollector.maxDifference());

        System.out.println(nextnewMaxDifference);


    }

}
