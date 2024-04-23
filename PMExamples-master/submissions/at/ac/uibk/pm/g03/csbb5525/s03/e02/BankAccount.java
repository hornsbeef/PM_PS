package at.ac.uibk.pm.g03.csbb5525.s03.e02;

import java.util.Objects;
import java.util.UUID;

public class BankAccount {

    private final Customer customer;
    private final String iban;
    private final String bic;

    private int balance = 0;

    public BankAccount(Customer customer, String iban, String bic) {
        this.customer = customer;
        this.iban = iban;
        this.bic = bic;
    }

    public BankAccount(BankAccount account){
        this.customer = account.getCustomer();
        this.iban = account.getIban();
        this.bic = account.bic();
        this.balance = account.getBalance();
    }

    public int getBalance() {
        return balance;
    }

    public String getIban() {
        return iban;
    }

    public String bic() { return bic; }

    public Customer getCustomer() {
        return customer;
    }

    public void deposit(int amount){        //implemented like this because required.
        balance += amount;
        System.out.println("deposited " + amount + " to " + iban + ". new balance is " + balance);
    }

    public boolean withdraw(int amount){
        int potentialBalance = balance - amount;
        if(potentialBalance < customer.getCreditRating().getRatingValue()){
            System.out.println("credit rating is too low");
            return false;
        }
        balance -= amount;
        System.out.println("withdrew " + amount + " from " + iban + ". new balance is " + balance);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount that)) return false;
        return Objects.equals(iban, that.iban) && Objects.equals(bic, that.bic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, bic);
    }
}
