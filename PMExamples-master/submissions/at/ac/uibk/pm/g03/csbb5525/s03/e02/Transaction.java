package at.ac.uibk.pm.g03.csbb5525.s03.e02;

import java.util.UUID;

public class Transaction {
    private final String id = UUID.randomUUID()
                                  .toString();

    private String source;        //for deposit / withdraw -> make source and target the same?
    // NO! use separate BankAccount called Depositer
    private String target;
    private int amount;
    private TransactionStatus status;


    public Transaction(BankAccount source, BankAccount target, int amount) {
        transactionMethod(source, target, amount);
    }


    private void transactionMethod(BankAccount source, BankAccount target, int amount) {
        this.source = source.getIban();
        this.target = target.getIban();

        this.amount = amount;

        boolean transferStatus = source.withdraw(amount);
        if (transferStatus) {
            target.deposit(amount);
            status = TransactionStatus.SUCCESS;
        } else {
            status = TransactionStatus.FAILURE;
        }
    }

    public TransactionStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {

        return
                "Transaction ID: " + this.id + "\n"
                        + "Status: " + this.status + "\n"
                        + "Source-Iban: " + this.source + "\n"
                        + "Target-Iban: " + this.target + "\n"
                        + "Amount: " + this.amount + "\n";
    }


}
