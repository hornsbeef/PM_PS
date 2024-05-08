package at.ac.uibk.pm.g03.csbb5525.s06.e03;

public class PasswordChecker {

    public PasswordStrength checkPassword(User user, String password){

        boolean length = is16long(password);
        boolean twoDigits = hasTwoDigits(password);
        boolean threeLowerCase = hasThreeLowerCaseLetters(password);
        boolean twoUpperCase = hasTwoUpperCaseLetters(password);
        boolean twoSpecialChars = hasTwoSpecialChar(password);

        //testing:length && twoDigits &&threeLowerCase && twoUpperCase
        return twoSpecialChars ? PasswordStrength.STRONG : PasswordStrength.WEAK;

    }

    private static boolean hasTwoSpecialChar(String password) {
        return password.matches(".*[\\-\\?\\!\\%\\&\\=\\+\\[\\]].*[\\-\\?\\!\\%\\&\\=\\+\\[\\]].*");
    }

    private static boolean hasTwoUpperCaseLetters(String password) {
        return password.matches(".*[A-Z].*[A-Z].*");
    }

    private static boolean hasThreeLowerCaseLetters(String password) {
        return password.matches(".*[a-z].*[a-z].*[a-z].*");
    }

    private static boolean hasTwoDigits(String password) {
        return password.matches(".*\\d.*\\d.*");
    }

    private static boolean is16long(String password) {
        return password.length() >= 16;
    }

}
