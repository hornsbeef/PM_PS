package at.ac.uibk.pm.g03.csbb5525.s06.e04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NameServiceTest {

    public NameServiceTest(){}

    @Test
    void constructFullName() {
        Logger logger = new LoggerImpl();
        NameService nameService = new NameService(logger);
        String fullName = nameService.constructFullName("Max", "MUSTERMANN");
        assertEquals("Max MUSTERMANN", fullName);
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    @DisplayName("no CAPS")
    void constructFullNameNoCaps() {
        LoggerSpy loggerSpy = LoggerSpy.spy(new LoggerImpl());
        NameService nameService = new NameService(loggerSpy);
        String fullName = nameService.constructFullName("Max", "Mustermann");

        assertAll(
                () -> assertEquals("Max Mustermann", fullName),
                () -> assertEquals(0, loggerSpy.getInteractions())
                );
    }

    @Test
    @DisplayName("Firstname CAPS")
    void constructFullNameFirstNameCaps() {
        LoggerSpy loggerSpy = LoggerSpy.spy(new LoggerImpl());
        NameService nameService = new NameService(loggerSpy);
        String fullName = nameService.constructFullName("MAX", "Mustermann");

        assertAll(
                () -> assertEquals("MAX Mustermann", fullName),
                () -> assertEquals(1, loggerSpy.getInteractions())
                );
    }

    @Test
    @DisplayName("Lastname CAPS")
    void constructFullNameLastNameCaps() {
        LoggerSpy loggerSpy = LoggerSpy.spy(new LoggerImpl());
        NameService nameService = new NameService(loggerSpy);
        String fullName = nameService.constructFullName("Max", "MUSTERMANN");

        assertAll(
                () -> assertEquals("Max MUSTERMANN", fullName),
                () -> assertEquals(1, loggerSpy.getInteractions())
                );
    }

    @Test
    @DisplayName("Both CAPS")
    void constructFullNameBothCaps() {
        LoggerSpy loggerSpy = LoggerSpy.spy(new LoggerImpl());
        NameService nameService = new NameService(loggerSpy);
        String fullName = nameService.constructFullName("MAX", "MUSTERMANN");

        assertAll(
                () -> assertEquals("MAX MUSTERMANN", fullName),
                () -> assertEquals(2, loggerSpy.getInteractions())
                );
    }


    @Test
    @DisplayName("myTest")
    public void myTest(){
        double actual = 1d / 3d;
        double expected = 0.333;
        assertAll(
                //() -> assertEquals(expected, actual, "this probably fails"),
                //() -> assertEquals(expected, actual, 0.0001, "this fails as well"),
                () -> assertEquals(expected, actual, 0.001, "this works")
                );
    }
}
