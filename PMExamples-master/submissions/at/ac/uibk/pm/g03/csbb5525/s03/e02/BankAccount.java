package at.ac.uibk.pm.g03.csbb5525.s03.e02;

public class BankAccount {
    private Customer customer;
    private Iban iban;
    private int balance;
    private BankingSystem bankingSystem;

    public BankAccount(Customer customer, BankingSystem bankingSystem) {
        this.customer = customer;
        this.bankingSystem = bankingSystem;
        this.iban = new Iban(this);
        this.balance = 0;
    }

    public int getBalance() {
        return balance;
    }

    public Iban getIban() {
        return iban;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setBalance(int amount, Transaction transaction) {
        if(transaction.getStatus() == TransactionStatus.SUCCESS){
            this.balance += amount;
        }else{
            //this should not happen. maybe throw error.
            System.out.println("Transaction failed");
        }
    }
    public void deposit(int amount){        //implemented like this because required.
        TransactionStatus depositSuccess = bankingSystem.transfer(bankingSystem, iban, amount, true);
        //could give customer feedback if the deposit was successful.
        System.out.println("Deposit status: "+ depositSuccess.name());
    }

    public void withdraw(int amount){
        TransactionStatus withdrawalSuccess = bankingSystem.transfer(iban, bankingSystem, amount, true);
        System.out.println("Withdrawal status: "+ withdrawalSuccess.name());
    }


}
