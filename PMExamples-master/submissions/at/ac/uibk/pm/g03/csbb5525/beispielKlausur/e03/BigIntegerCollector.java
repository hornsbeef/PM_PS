package at.ac.uibk.pm.g03.csbb5525.beispielKlausur.e03;

import java.math.BigInteger;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class BigIntegerCollector implements Collector<BigInteger, ArrayList<BigInteger>, Optional<BigInteger>> {


    //public static Collector<BigInteger, Object, Optional<BigInteger>> maxDifference() {
    public static BigIntegerCollector maxDifference() {
        return new BigIntegerCollector();

    }

    @Override
    public Supplier<ArrayList<BigInteger>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<ArrayList<BigInteger>, BigInteger> accumulator() {
        return ArrayList::add;
    }

    @Override
    public BinaryOperator<ArrayList<BigInteger>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<ArrayList<BigInteger>, Optional<BigInteger>> finisher() {

        Function<ArrayList<BigInteger>, Optional<BigInteger>> finisherFunction =
                (list) -> {
            if(list.isEmpty()){
                return Optional.empty();
            }

            Optional<BigInteger> max = list.stream().filter(Objects::nonNull).max(BigInteger::compareTo);
            Optional<BigInteger> min = list.stream().filter(Objects::nonNull).min(BigInteger::compareTo);

            return Optional.of(max.get().subtract(min.get()));

                };


        return finisherFunction;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.UNORDERED);
    }
}
