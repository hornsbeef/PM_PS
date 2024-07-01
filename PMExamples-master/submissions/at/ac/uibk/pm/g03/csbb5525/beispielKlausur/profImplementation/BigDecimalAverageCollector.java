package at.ac.uibk.pm.g03.csbb5525.beispielKlausur.profImplementation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/*
 * This is the intermediate step of the implementation.
 * In the final implementation  I moved and renamed the public
 * static inner class ImplementationDetail to BigDecimalCollector, renamed it to BigDecimalAverageCollectorDetail and
 * made it private.
 */

public class BigDecimalAverageCollector implements
        Collector<BigDecimal, BigDecimalAverageCollector.ImplementationDetail, Optional<BigDecimal>> {

    @Override
    public Supplier<ImplementationDetail> supplier() {
        return ImplementationDetail::new;
    }

    @Override
    public BiConsumer<ImplementationDetail, BigDecimal> accumulator() {
        return ImplementationDetail::add;
    }

    @Override
    public BinaryOperator<ImplementationDetail> combiner() {
        return ImplementationDetail::combine;
    }

    @Override
    public Function<ImplementationDetail, Optional<BigDecimal>> finisher() {
        return ImplementationDetail::computeAverage;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of();
    }

////////////////////////////////////////////////////////////////////////////////////////////////
    public static class ImplementationDetail {
        private BigDecimal sum = BigDecimal.ZERO;
        long n = 0;

        private void add(BigDecimal element) {
            sum = sum.add(element);
            ++n;
        }

        private ImplementationDetail combine(ImplementationDetail other) {
            sum = sum.add(other.sum);
            n += other.n;
            return this;
        }

        private Optional<BigDecimal> computeAverage() {
            return n == 0 ? Optional.empty() : Optional.of(sum.divide(BigDecimal.valueOf(n), MathContext.UNLIMITED));
        }

        private Optional<BigDecimal> computeAverage(int scale, RoundingMode roundingMode) {
            return n == 0 ? Optional.empty() : Optional.of(sum.divide(BigDecimal.valueOf(n), scale, roundingMode));
        }

        private Optional<BigDecimal> computeAverage(MathContext mathContext) {
            return n == 0 ? Optional.empty() : Optional.of(sum.divide(BigDecimal.valueOf(n), mathContext));
        }
    }
}
