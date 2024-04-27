package at.ac.uibk.pm.g03.csbb5525.s04.e02;

import java.util.Objects;

public class PasswordValidator implements Validator{

    public boolean isValid(User user){
        return !Objects.equals(user.getUsername(), user.getPassword());     //should work because it uses String for username and password -> correct?
    }
}
