package at.ac.uibk.pm.g03.csbb5525.s04.e02;

public abstract class BinaryValidator {

    private final Validator validator1;
    private final Validator validator2;

    //exercise: implement constructor, that takes 2 Validator-types and saves them as obj vars.
    public BinaryValidator(Validator validator1, Validator validator2) {
        this.validator1 = validator1;
        this.validator2 = validator2;
    }


    public Validator getValidator1() {
        return validator1;
    }

    public Validator getValidator2() {
        return validator2;
    }
}
