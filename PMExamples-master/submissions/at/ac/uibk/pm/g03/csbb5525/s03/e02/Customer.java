package at.ac.uibk.pm.g03.csbb5525.s03.e02;

import java.util.ArrayList;
import java.util.Optional;

public class Customer {
    private String firstName;
    private String lastName;
    private CreditRating creditRating = CreditRating.LOW;
    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();    //TODO: check if Optional is possible

    //todo: implement list of all accounts the customer has.

    public Customer(String firstName, String lastName, CreditRating creditRating){
        this.firstName = firstName;
        this.lastName = lastName;
        this.creditRating = creditRating;
    }

    public CreditRating getCreditRating() {
        return creditRating;
    }

    public void addBankAccounts(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }

    public BankAccount getBankAccount(int index) {
        Optional<BankAccount> returnAccount =  bankAccounts.get(index).
    }
}
