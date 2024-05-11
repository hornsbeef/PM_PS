package at.ac.uibk.pm.g03.csbb5525.s06.e03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
//must be static

public class PasswordCheckerTest {

    @ParameterizedTest(name = "invalidUserValue: firstName:{0}, lastName:{1}, bDay:{2}, bMonth:{3}, bYear:{4}")
    @CsvSource(value = {"null, asdf, 1, 1, 1999",
            "asdf, null, 31, 1, 1999",
            "asdf, fasd, 0, 1, 1999",
            "asdf, fasd, 31, 13, 1999",
            "asdf, fasd, 20, 1, 0"},
            nullValues = "null")
    void testInvalidParameters(String firstName, String lastName, int day, int month, int year) {
        Executable when = () -> new User(firstName, lastName, day, month, year);
        assertThrows(IllegalArgumentException.class, when);
    }

    //Exercise: Test every password guideline.
    //This seems impossible by calling the checkPassword Method, as the output will be too vague.
    //Therefore, every method implemented to check the guideline needs to be tested individually.
    //BUT: all methods have been written to be private - they serve no purpose outside the class.
    //Below 2 options to get around this obstacle have been implemented.
    //option 1: change private to public/package-private
    //option 2: use java.lang.reflect api

    @Test
    @DisplayName("Test:PasswordChecker:length")
    void testLength() throws NoSuchMethodException, IllegalAccessException,  java.lang.reflect.InvocationTargetException {
        //just for learning purposes: trying how to access a private static method for testing, using
        //java.lang.reflect
        //accessing private Methods seems like a bad thing considering OOP and testing ideals;
        //How to better test methods that do not need to be public, but need testing?
        //one option would be to use an annotation like @VisibleForTesting - but that is not included in standard java lib

        Method privateMethod = PasswordChecker.class.getDeclaredMethod("is16long", String.class);
        privateMethod.setAccessible(true);

        boolean result = (boolean)privateMethod.invoke(null, "0123456789ABCDEF");
        //If the underlying method is static, then the specified obj argument is ignored. It may be null.
        //https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html#invoke-java.lang.Object-java.lang.Object...-
        assertTrue(result);
    }

    @Test
    @DisplayName("Check if the password contains illegal Characters")
    void testContainsIllegalCharacters() {
        PasswordChecker checker = new PasswordChecker();
        Executable when = () -> checker.checkIllegalCharacters(" _ ");
        assertThrows(PasswordIllegalException.class, when);
    }

    @ParameterizedTest(name = "Check if the password contains the users birthday")
    @ValueSource(strings = {"pass12", "2", "2022pass"})
    void testContainsUserBirthday(String password) {
        User user = new User("First", "Last", 12, 2, 2022);
        boolean containsBirthday = PasswordChecker.containsBirthday(user, password);
        assertTrue(containsBirthday);
    }

    @ParameterizedTest(name = "Check if the password contains the users last name")
    @ValueSource(strings = {"passlast", "Last2", "2022Lastpass"})
    void testContainsUserLastName(String password) {
        User user = new User("First", "Last", 12, 2, 2022);
        boolean containsLastName = PasswordChecker.containsLastName(user, password);
        assertTrue(containsLastName);
    }

    @ParameterizedTest(name = "Check if the password contains the users first name")
    @ValueSource(strings = {"fIrsT22", "fFIRST", "abscdfirst"})
    void testContainsUserFirstName(String password) {
        User user = new User("First", "Last", 12, 2, 2022);
        assertTrue(PasswordChecker.containsFirstName(user, password));
    }

    @ParameterizedTest(name = "Check if the password contains 2 special chars")
    @ValueSource(strings = {"-?", "!%", "&=", "+[", "]]"})
    void testContains2SpecialChars(String password) {
        assertTrue(PasswordChecker.hasTwoSpecialChar(password));
    }

    @ParameterizedTest(name = "Check if the password contains 2 upper case letters")
    @ValueSource(strings = {"LAsdf", "SDfdf"})
    void testContains2UpperLetters(String password) {
        assertTrue(PasswordChecker.hasTwoUpperCaseLetters(password));
    }

    @ParameterizedTest(name = "Check if the password contains 3 lower case letters")
    @ValueSource(strings = {"LAsdf", "SDfdf"})
    void testContains3LowerLetters(String password) {
        assertTrue(PasswordChecker.hasThreeLowerCaseLetters(password));
    }

    @ParameterizedTest(name = "Check if the password contains 2 digits")
    @ValueSource(strings = {"LAsd46f", "S2D2fdf"})
    void testContains2Digits(String password) {
        assertTrue(PasswordChecker.hasTwoDigits(password));
    }

    //Exercise: at least one test per PasswordStrength:

    @ParameterizedTest(name = "Check Strength TOO_WEAK")
    @ValueSource(strings = {"LA", "password", "1345"})
    void testStrengthTooWeak(String password) throws PasswordIllegalException{
        PasswordChecker checker = new PasswordChecker();
        User user = new User("First", "Last", 12, 2, 2022);
        assertEquals(PasswordStrength.TOO_WEAK, checker.checkPassword(user, password));
    }

    @ParameterizedTest(name = "Check Strength WEAK")
    @ValueSource(strings = {"LAfir", "password13", "1345AB"})
    void testStrengthWeak(String password) throws PasswordIllegalException{
        PasswordChecker checker = new PasswordChecker();
        User user = new User("First", "Last", 12, 2, 2022);
        assertEquals(PasswordStrength.WEAK, checker.checkPassword(user, password));
    }

    @ParameterizedTest(name = "Check Strength MEDIUM")
    @ValueSource(strings = {"LAfir!!", "password13AF", "1&345AB!"})
    void testStrengthMedium(String password) throws PasswordIllegalException{
        PasswordChecker checker = new PasswordChecker();
        User user = new User("First", "Last", 12, 2, 2022);
        assertEquals(PasswordStrength.MEDIUM, checker.checkPassword(user, password));
    }

    @ParameterizedTest(name = "Check Strength STRONG")
    @ValueSource(strings = {"LAfir!!131011ffff", "passsssword13AF]&", "1&345AB!asdfasdf"})
    void testStrengthStrong(String password) throws PasswordIllegalException{
        PasswordChecker checker = new PasswordChecker();
        User user = new User("First", "Last", 12, 2, 2022);
        assertEquals(PasswordStrength.STRONG, checker.checkPassword(user, password));
    }

    //Exercise:
    //"Testen der Grenzen zwischen den Stufen der PasswordStrength"
    //for me unclear what is meant here
    // -> I'll rewrite checkPassword() so the switch-case can be tested...

    @ParameterizedTest(name = "Checking passwordStrengthTranslator")
    @CsvSource(value = {"0, TOO_WEAK", "1, TOO_WEAK", "2, WEAK", "3, MEDIUM", "4, MEDIUM", "5, STRONG"})
    void testStrengthTranslator(int input, PasswordStrength expected){
        PasswordChecker checker = new PasswordChecker();
        assertEquals(expected,checker.passwordStrengthTranslator(input));
    }





}
