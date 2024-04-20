package at.ac.uibk.pm.g03.csbb5525.s03.e02;

public class BankAccount {
    private Customer customer;
    private Iban iban;
    private int balance;

    public BankAccount(Customer customer) {
        this.customer = customer;
        this.iban = new Iban(this);
        this.balance = 0;
    }

    public int getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setBalance(int amount, Transaction transaction) {
        if(transaction.getStatus() == Transactionstatus.SUCCESS){
            this.balance += amount;
        }else{
            //do nothing. this should not happen. maybe throw error.
        }

    }
}
