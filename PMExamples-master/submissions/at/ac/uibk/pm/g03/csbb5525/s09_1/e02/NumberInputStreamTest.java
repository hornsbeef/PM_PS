package at.ac.uibk.pm.g03.csbb5525.s09_1.e02;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class NumberInputStreamTest {

    @Test
    public void read() throws IOException {
        var number = "+43 664 12-34-5";
        //var number = "+aa43 664 12-34-5";
        try (InputStream in = new ByteArrayInputStream(number.getBytes())) {
            try (var numberIn = new NumberInputStream(in)) {
                assertArrayEquals("+4366412345".getBytes(), numberIn.readNBytes(11));
                //assertArrayEquals("+aa4366412345".getBytes(), numberIn.readNBytes(13));
            }
        }
    }
}
