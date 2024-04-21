package at.ac.uibk.pm.g03.csbb5525.s03.e02;

import java.util.ArrayList;
import java.util.Optional;

public class Customer {
    private String firstName;
    private String lastName;
    private CreditRating creditRating = CreditRating.LOW;
    private ArrayList<Optional<BankAccount>> bankAccounts = new ArrayList<>();



    public Customer(String firstName, String lastName, CreditRating creditRating){
        this.firstName = firstName;
        this.lastName = lastName;
        this.creditRating = creditRating;
    }

    public CreditRating getCreditRating() {
        return creditRating;
    }


    public void addBankAccounts(BankAccount bankAccount) {
        bankAccounts.add(Optional.ofNullable(bankAccount));
    }
    public void addBankAccounts(int index, BankAccount bankAccount) {
        bankAccounts.ensureCapacity(index+1);
        //System.out.println("Size of List: "+bankAccounts.size());
        //System.out.println("Index: "+index);
        for (int i = bankAccounts.size(); i < index; i++) {
            bankAccounts.add(Optional.empty());
        }
        //System.out.println("Size of List: "+bankAccounts.size());
        bankAccounts.add(index, Optional.ofNullable(bankAccount));
    }

    public Optional<BankAccount> getBankAccount(Customer customer, BankingSystem bankingSystem,int index) {

        if(index >= 0 && index < bankAccounts.size()){
            Optional<BankAccount> returnAccount = bankAccounts.get(index);
            return returnAccount;
        }else{
            //return Optional.empty();
            System.out.println("No bank account found\n" +
                               "Now creating new bank account with balance 0. \n" +
                               "(at the designated index)\n");
            bankingSystem.createAccount(customer, index);
            return Optional.empty();
        }


    }
}
