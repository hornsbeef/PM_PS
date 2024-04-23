package at.ac.uibk.pm.g03.csbb5525.s03.e02;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Customer {
    private final List<BankAccount> accounts = new ArrayList<>();

    private String firstName;
    private String lastName;
    private CreditRating creditRating = CreditRating.LOW;


    public Customer(String firstName, String lastName, CreditRating creditRating){
        this.firstName = firstName;
        this.lastName = lastName;
        this.creditRating = creditRating;
    }

    public CreditRating getCreditRating() {
        return creditRating;
    }


    public void addBankAccounts(BankAccount bankAccount) {
        accounts.add(bankAccount);
    }

    public List<BankAccount> getBankAccounts() {
        return accounts;
    }
}
