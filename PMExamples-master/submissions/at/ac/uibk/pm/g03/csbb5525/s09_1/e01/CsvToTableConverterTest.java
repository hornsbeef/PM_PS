package at.ac.uibk.pm.g03.csbb5525.s09_1.e01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvToTableConverterTest {

    @Test
    public void convert() {
        var csv = """
                Aaaa,1,!!
                bb,22,...
                CCC,333,?""";
        var expected = """
                Aaaa | 0001 |   !!
                bb   | 0022 |  ...
                CCC  | 0333 |    ?""";
        assertEquals(expected, CsvToTableConverter.convert(csv));
    }
}
