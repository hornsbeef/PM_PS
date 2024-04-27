package at.ac.uibk.pm.g03.csbb5525.s04.e02;

public class UsernameValidator implements Validator{

    public boolean isValid(User user) {
        return user.getUsername()
                   .length() >= 3;
    }
}
