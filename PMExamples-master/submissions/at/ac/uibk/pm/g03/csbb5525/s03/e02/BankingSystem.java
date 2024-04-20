package at.ac.uibk.pm.g03.csbb5525.s03.e02;

import java.util.ArrayList;
public class BankingSystem {

    private ArrayList<BankAccount> bankAccountList= new ArrayList();

    private ArrayList<Transaction> transactionList = new ArrayList<>();



    public void createAccount(Customer customer){
        BankAccount newAccount = new BankAccount(customer);
        bankAccountList.add(newAccount);
    }

    public Transactionstatus transfer(Iban source, Iban target, int amount){

        Transaction transaction = new Transaction( source, target, amount);

        return //TODO
    }



}
