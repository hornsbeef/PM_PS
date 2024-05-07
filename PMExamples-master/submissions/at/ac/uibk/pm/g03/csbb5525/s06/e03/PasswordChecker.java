package at.ac.uibk.pm.g03.csbb5525.s06.e03;

public class PasswordChecker {

    public PasswordStrength checkPassword(User user, String password){

        boolean length = is16long(password);
        boolean twoDigits = hasTwoDigits(password);

        //testing:
        return length && twoDigits ? PasswordStrength.STRONG : PasswordStrength.WEAK;

    }

    private static boolean hasTwoDigits(String password) {
        return password.matches(".*\\d.*\\d.*");
    }

    private static boolean is16long(String password) {
        return password.length() >= 16;
    }

}
