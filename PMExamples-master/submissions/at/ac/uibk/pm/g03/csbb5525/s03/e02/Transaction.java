package at.ac.uibk.pm.g03.csbb5525.s03.e02;

public class Transaction {
    private int id;

    private Iban source;        //for deposit / withdraw -> make source and target the same?
                                // NO! use separate BankAccount called Depositer
    private Iban target;
    private int amount;
    private Transactionstatus status;

    private boolean isDeposit = false;
    private boolean isWithdrawal = false;


    //todo: create second/third constructor for deposit/withdrawl.
    public Transaction(Iban source, Iban target, int amount) {
        transactionMethod(source, target, amount);
    }
    public Transaction(Iban source, Iban target, int amount, boolean isDeposit) {
        this.isDeposit = true;
        transactionMethod(source, target, amount);
    }
    public Transaction(boolean isWithdrawal, Iban source, Iban target, int amount) {
        this.isWithdrawal = true;
        transactionMethod(source, target, amount);
    }


    private void transactionMethod(Iban source, Iban target, int amount) {
        this.source = source;
        this.target = target;

        this.id = this.hashCode();  //again ignoring Hash Collisions
        this.amount = amount;

        BankAccount sourceAccount = source.getIbanAccount();
        BankAccount targetAccount = target.getIbanAccount();
        boolean transferSuccessful = false; //must be initialized.

        if(!this.isDeposit){
            CreditRating sourceRating = sourceAccount.getCustomer()
                                                     .getCreditRating();

            transferSuccessful = (sourceAccount.getBalance() - amount) >= sourceRating.getRatingValue();
        } else if (this.isDeposit) {    //todo: check why says is always true???
            transferSuccessful = true;
        }


        if (transferSuccessful) {
            this.status = Transactionstatus.SUCCESS;


            if (!this.isDeposit){
                sourceAccount.setBalance(-amount, this);    //TODO: CHECK IF WORKS
            } else if (this.isDeposit) {
                //the Bank's account shows total amount of money that is stored in this Banking system.
                sourceAccount.setBalance(+amount, this);    //TODO: CHECK IF WORKS
            }

            if(!this.isWithdrawal){
                targetAccount.setBalance(+amount, this);    //TODO: CHECK IF WORKS
            } else if (this.isWithdrawal) {
                //the Bank's account shows total amount of money that is stored in this Banking system.
                targetAccount.setBalance(-amount, this);    //TODO: CHECK IF WORKS
            }


        } else if (!transferSuccessful) {   //TODO: check why says always true
            this.status = Transactionstatus.FAILURE;
        }
    }

    public Transactionstatus getStatus() {
        return status;
    }

    @Override
    public String toString(){
        String transactionType = isDeposit ? "DEPOSIT" : (isWithdrawal ? "WITHDRAWAL" : "TRANSFER");

        return
                transactionType
                +"Transaction ID: " + this.id
                +"Status: " + this.status
                +"Source: " + this.source
                +"Target: " + this.target
                +"Amount: " + this.amount;
    }






}
