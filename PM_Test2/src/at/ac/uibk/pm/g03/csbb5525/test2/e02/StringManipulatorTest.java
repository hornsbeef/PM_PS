package at.ac.uibk.pm.g03.csbb5525.test2.e02;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


import static org.junit.jupiter.api.Assertions.*;




public class StringManipulatorTest {


    @Test
    @DisplayName("Mehrere Woerter")
    void testMultipleWords(){
        String input = "abcd efgh ijkl";
        String expected ="Abcd Efgh Ijkl";
        assertEquals(expected, StringManipulator.capitalizeWords(input));

    }

    @Test
    @DisplayName("Sonderzeichen")
    void testSpecialChars(){
        String input = "abcd efgh ijkl!!.1";
        String expected ="Abcd Efgh Ijkl!!.1";
        assertEquals(expected, StringManipulator.capitalizeWords(input));
        //actually check the special Character at the point in the string where it actually changes!
        //so only fist Character of a word!!

    }

    @Test
    @DisplayName("einzel Charr")
    void testSingelChar(){
        String input = "a";
        String expected ="A";
        assertEquals(expected, StringManipulator.capitalizeWords(input));

    }

    @Test
    @DisplayName("NUll-INput")
    void testNullInput(){
        String input = null;
        Executable when = () -> StringManipulator.capitalizeWords(input);
        assertThrows(IllegalArgumentException.class, when);

    }

    @Test
    @DisplayName("Empty-INput")
    void testEmptyInput(){
        String input = "";
        Executable when = () -> StringManipulator.capitalizeWords(input);
        assertThrows(IllegalArgumentException.class, when);

    }






}
