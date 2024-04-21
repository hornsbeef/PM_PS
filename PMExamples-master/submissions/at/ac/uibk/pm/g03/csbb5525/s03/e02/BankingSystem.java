package at.ac.uibk.pm.g03.csbb5525.s03.e02;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
public class BankingSystem {


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
        BankAccount newAccount = getBankAccount(customer);
        customer.addBankAccounts(newAccount);
    }

    public void createAccount(Customer customer, int index){
        BankAccount newAccount = getBankAccount(customer);
        customer.addBankAccounts(index, newAccount);
    }

    private BankAccount getBankAccount(Customer customer) {
        BankAccount newAccount = new BankAccount(customer, this);
        bankAccountList.add(newAccount);
        return newAccount;
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
        System.out.println("\nPrinting transactions:\n");
        transactionList.forEach(transaction -> System.out.println(transaction.toString())); //TODO:Check if works
    }

    public void printBankAccounts(){
        System.out.println("\nPrinting bank accounts:\n");
        bankAccountList.forEach(bankAccount -> System.out.println(bankAccount.toString() + "\n"));
    }

}
