package at.ac.uibk.pm.g03.csbb5525.s04.e02;

public class AndValidator extends BinaryValidator implements Validator {


    public AndValidator(Validator validator1, Validator validator2) {
        super(validator1, validator2);
    }

    @Override
    public boolean isValid(User user) {
        return getValidator1().isValid(user) && getValidator2().isValid(user);
    }
}
