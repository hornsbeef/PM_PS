package at.ac.uibk.pm.g03.csbb5525.s03.e02;

import java.util.ArrayList;
public class BankingSystem {

    //Todo: create a BankAccount that belongs to the Bank itself for deposits and withdrawals
    //for deposit -> adds to total bank balance
    //for withdrawl -> takes money from Bank balance

    private ArrayList<BankAccount> bankAccountList= new ArrayList();

    private ArrayList<Transaction> transactionList = new ArrayList<>();

    private Customer owner;
    private BankAccount bank;
    public BankingSystem(Customer owner) {
        this.owner = owner;
        this.bank = new BankAccount(owner, this);
        //bankAccountList.add(bank);

    }

    public void createAccount(Customer customer){
        BankAccount newAccount = new BankAccount(customer, this);
        bankAccountList.add(newAccount);
    }

    public Transactionstatus transfer(Iban source, Iban target, int amount){

        Transaction transaction = new Transaction( source, target, amount);
        transactionList.add(transaction);

        return transaction.getStatus();
    }
    public Transactionstatus transfer(BankingSystem bank, Iban target, int amount, boolean isDeposit){
        //this is for depositing.
        Transaction deposit = new Transaction(this.bank.getIban(), target, amount, isDeposit);
        transactionList.add(deposit);
        return deposit.getStatus();
    }
    public Transactionstatus transfer(Iban source, BankingSystem bank,  int amount, boolean isWithdrawal){
        //this is for withdrawals.
        Transaction withdrawal = new Transaction(isWithdrawal, source, this.bank.getIban(), amount);
        transactionList.add(withdrawal);
        return withdrawal.getStatus();
    }

    public void printTransactions(){
        transactionList.forEach(transaction -> System.out.println(transaction.toString())); //TODO:Check if works
    }


}
