package at.ac.uibk.pm.g03.csbb5525.s06.e03;

//import static at.ac.uibk.pm.g03.csbb5525.s06.e03.PasswordStrength.*;
//was not sure, if that is ok to import for Exercises

public class PasswordChecker {

    private static final String illegalChars =
            ".*"+
            "[^a-zA-Z0-9?\\-!%&=+\\[\\]]"+
            ".*";
    private int passwordStrengthCounter = 0;

    public PasswordStrength checkPassword(User user, String password) throws PasswordIllegalException {
        //Fail fast:
        checkNullOrEmpty(password);
        checkIllegalCharacters(password);
        checkContainsUserInfo(user, password);

        //Strength check:
        if(is16long(password)) passwordStrengthCounter++;
        if(hasTwoDigits(password)) passwordStrengthCounter++;
        if(hasThreeLowerCaseLetters(password)) passwordStrengthCounter++;
        if(hasTwoUpperCaseLetters(password)) passwordStrengthCounter++;
        if(hasTwoSpecialChar(password)) passwordStrengthCounter++;

        return passwordStrengthTranslator(passwordStrengthCounter);


    }

    //extracted for testing purposes.
    PasswordStrength passwordStrengthTranslator(int counter) {
        return switch (counter) {
            case 0, 1 -> PasswordStrength.TOO_WEAK;
            case 2 -> PasswordStrength.WEAK;
            case 3, 4 -> PasswordStrength.MEDIUM;
            case 5 -> PasswordStrength.STRONG;
            default -> throw new IllegalStateException("Unexpected value: " + passwordStrengthCounter);
        };
    }


    private static void checkContainsUserInfo(User user, String password) throws PasswordIllegalException {
        if(containsFirstName(user, password)||containsLastName(user, password)||containsBirthday(user, password)) {
            throw new PasswordIllegalException("Password may not contain any information like your first or last name, or birthday!");
        }
    }

    private static void checkNullOrEmpty(String password) throws PasswordIllegalException {
        if(password == null || password.isEmpty()) {
            throw new PasswordIllegalException("Password cannot be null or empty");
        }
    }

    //the following methods used to be private, but due to testing -> package private.

    //test implemented
    void checkIllegalCharacters(String password) throws PasswordIllegalException {
        if(password.matches(illegalChars)){
            throw new PasswordIllegalException("Illegal characters in password");
        }
    }

    //test implemented
    static boolean containsBirthday(User user, String password) {
        return password.matches(".*" + user.getBirthday()
                                           .getDayOfMonth() + ".*") ||
                password.matches(".*" + user.getBirthday()
                                            .getMonthValue() + ".*") ||
                password.matches(".*" + user.getBirthday()
                                            .getYear() + ".*");
    }

    //test implemented
    static boolean containsLastName(User user, String password) {
        //return password.matches(".*" + user.getLastName() + ".*");
        return password.toLowerCase().contains(user.getLastName().toLowerCase());
    }

    //test implemented
    static boolean containsFirstName(User user, String password) {
        //return password.matches(".*" + user.getFirstName() + ".*");
        return password.toLowerCase().contains(user.getFirstName().toLowerCase());
    }
    //test implemented
    static boolean hasTwoSpecialChar(String password) {
        return password.matches(".*[\\-?!%&=+\\[\\]].*[\\-?!%&=+\\[\\]].*");
    }

    //test implemented
    static boolean hasTwoUpperCaseLetters(String password) {
        return password.matches(".*[A-Z].*[A-Z].*");
    }
    //test implemented
    static boolean hasThreeLowerCaseLetters(String password) {
        return password.matches(".*[a-z].*[a-z].*[a-z].*");
    }
    //test implemented
    static boolean hasTwoDigits(String password) {
        return password.matches(".*\\d.*\\d.*");
    }


    //for learning purposes I have left this method as private
    //-> so I have to use the java.reflection
    //test created
    private static boolean is16long(String password) {
        return password.length() >= 16;
    }

}
