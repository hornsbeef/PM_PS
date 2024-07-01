package at.ac.uibk.pm.g03.csbb5525.beispielKlausur.profImplementation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Optional;
import java.util.stream.Collector;

public class BigDecimalCollector {
    private BigDecimalCollector() {
    }

    /*
     * This was the Original implementation before moving the ImplementationDetail from BigDecimalAverageCollector
     * to this class
     public static BigDecimalAverageCollector averageCollector() {
         return new BigDecimalAverageCollector();
    }
    */



    /*
    The Collector.of method in Java provides a way to create a custom collector by specifying how elements should be collected.
     */
    public static Collector<BigDecimal, ?, Optional<BigDecimal>> averageCollector() {
        return Collector.of(
                BigDecimalAverageCollectorDetail::new,      //supplier
                BigDecimalAverageCollectorDetail::add,      //accumulator
                BigDecimalAverageCollectorDetail::combine,  //combiner
                BigDecimalAverageCollectorDetail::computeAverage    //?finisher
                /*
                Since characteristics are optional, you only need to include them if you need to specify certain behaviors.
                 If the default behavior is sufficient, you can omit the Collector.Characteristics entirely,
                 as seen in the provided code snippet.
                 */
        );
    }

    public static Collector<BigDecimal, ?, Optional<BigDecimal>> averageCollector(int scale, RoundingMode roundingMode) {
        return Collector.of(
                BigDecimalAverageCollectorDetail::new,
                BigDecimalAverageCollectorDetail::add,
                BigDecimalAverageCollectorDetail::combine,
                c -> c.computeAverage(scale, roundingMode)
        );
    }

    public static Collector<BigDecimal, ?, Optional<BigDecimal>> averageCollector(MathContext mathContext) {
        return Collector.of(
                BigDecimalAverageCollectorDetail::new,
                BigDecimalAverageCollectorDetail::add,
                BigDecimalAverageCollectorDetail::combine,
                c -> c.computeAverage(mathContext)
        );
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static class BigDecimalAverageCollectorDetail {
        private BigDecimal sum = BigDecimal.ZERO;
        long n = 0;

        private void add(BigDecimal element) {
            sum = sum.add(element);
            ++n;
        }

        private BigDecimalAverageCollectorDetail combine(BigDecimalAverageCollectorDetail other) {
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
