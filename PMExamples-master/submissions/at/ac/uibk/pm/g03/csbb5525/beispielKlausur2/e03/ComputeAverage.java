package at.ac.uibk.pm.g03.csbb5525.beispielKlausur2.e03;

import java.util.List;

public class ComputeAverage {

    public static double computeAVerage(List<Integer> input){
        int numberOfNumbers = input.size();
        Integer sum = input.stream().reduce(0, Integer::sum);

        return ((double)sum) / numberOfNumbers;

    }

    public static void main(String[] args) {
        List<Integer> iList = List.of(1,2,3,4);

        System.out.println(ComputeAverage.computeAVerage(iList));
    }


}


