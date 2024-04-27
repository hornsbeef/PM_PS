package at.ac.uibk.pm.g03.csbb5525.s04.e02;

public class PhoneNumberValidator implements Validator{

    public boolean isValid(User user){
        return user.getPhoneNumber() != null;
    }
}
