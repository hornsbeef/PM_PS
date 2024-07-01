package at.ac.uibk.pm.g03.csbb5525.beispielKlausur.profImplementation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Optional.empty
        System.out.println("number 1: "+
                Stream.<BigDecimal>of() //empty
                        .collect(BigDecimalCollector.averageCollector())
        );

        //0
        System.out.println("number 2: "+
                Stream.<BigDecimal>of()
                        .collect(BigDecimalCollector.averageCollector())
                        .orElse(BigDecimal.ZERO)
        );

        //Optional[4]
        System.out.println("number 3: "+
                Stream.of(BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ONE)
                        .collect(BigDecimalCollector.averageCollector())
        );


        //4
        System.out.println("number 4: "+
                Stream.of(BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ONE)
                        .collect(BigDecimalCollector.averageCollector())
                        .orElse(BigDecimal.ZERO)
        );


        //0.34
        System.out.println("number 5: "+
                Stream.of(BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ZERO)
                        .collect(BigDecimalCollector.averageCollector(2, RoundingMode.UP))
                        .orElse(BigDecimal.ZERO)
        );

    }
}
