package at.ac.uibk.pm.g03.csbb5525.s03.e02;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BankingSystem {


    private final List<BankAccount> bankAccountList = new ArrayList<>();

    private final List<Transaction> transactionList = new ArrayList<>();

    private Customer owner;
    private BankAccount bank;
    private final String bic;
    public BankingSystem(Customer owner, String bic) {
        this.owner = owner;
        this.bank = new BankAccount(owner, UUID.randomUUID().toString() ,bic);
        this.bic = bic;

    }

    public BankAccount createAccount(Customer customer){
        BankAccount newAccount = new BankAccount(customer,UUID.randomUUID().toString(), bic);
        customer.addBankAccounts(newAccount);
        return newAccount;
    }


    public TransactionStatus transfer(BankAccount source, BankAccount target, int amount){
        Transaction transaction = new Transaction( source, target, amount);
        transactionList.add(transaction);
        return transaction.getStatus();
    }

    public void printTransactions(){
        System.out.println("\nPrinting transactions:\n");
        transactionList.forEach(transaction -> System.out.println(transaction.toString()));
    }

    public void printBankAccounts(){
        System.out.println("\nPrinting bank accounts:\n");
        bankAccountList.forEach(bankAccount -> System.out.println(bankAccount.toString() + "\n"));
    }

}
