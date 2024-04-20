package at.ac.uibk.pm.g03.csbb5525.s03.e02;

public class Customer {
    private String firstName;
    private String lastName;
    private CreditRating creditRating;

    public Customer(String firstName, String lastName, CreditRating creditRating){
        this.firstName = firstName;
        this.lastName = lastName;
        this.creditRating = creditRating;
    }

    public CreditRating getCreditRating() {
        return creditRating;
    }
}
