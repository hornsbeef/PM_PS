package at.ac.uibk.pm.g03.csbb5525.s03.e02;

public class Transaction {
    private int id;

    private Iban source;        //for deposit / withdraw -> make source and target the same?
                                // NO! use separate BankAccount called Depositer
    private Iban target;
    private int amount;
    private Transactionstatus status;

    public Transaction(Iban source, Iban target, int amount) {

        this.source = source;
        this.target = target;

        this.id = this.hashCode();  //again ignoring Hash Collisions
        this.amount = amount;


        BankAccount sourceAccount = source.getIbanAccount();
        BankAccount targetAccount = target.getIbanAccount();

        CreditRating sourceRating = sourceAccount.getCustomer()
                                                 .getCreditRating();

        boolean transferSuccessful = (sourceAccount.getBalance() - amount) >= sourceRating.getRatingValue();

        if (transferSuccessful) {
            this.status = Transactionstatus.SUCCESS;
            //todo: transfer -> adjusting balances!
            sourceAccount.setBalance(-amount, this);    //TODO: CHECK IF WORKS
            targetAccount.setBalance(+amount, this);    //TODO: CHECK IF WORKS


        } else if (!(transferSuccessful)) {
            this.status = Transactionstatus.FAILURE;
        }

    }

    public Transactionstatus getStatus() {
        return status;
    }
}
