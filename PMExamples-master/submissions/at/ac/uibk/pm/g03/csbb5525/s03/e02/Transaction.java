package at.ac.uibk.pm.g03.csbb5525.s03.e02;

public class Transaction {
    private int id;

    private Iban source;        //for deposit / withdraw -> make source and target the same?
                                // NO! use separate BankAccount called Depositer
    private Iban target;
    private int amount;
    private TransactionStatus status;

    private boolean isDeposit = false;
    private boolean isWithdrawal = false;



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
        } else if (this.isDeposit) {    //this is always true, but sanity check
            transferSuccessful = true;
        }


        if (transferSuccessful) {
            this.status = TransactionStatus.SUCCESS;


            if (!this.isDeposit){
                sourceAccount.setBalance(-amount, this);
            } else if (this.isDeposit) {
                //the Bank's account shows total amount of money that is stored in this Banking system.
                sourceAccount.setBalance(+amount, this);
            }

            if(!this.isWithdrawal){
                targetAccount.setBalance(+amount, this);
            } else if (this.isWithdrawal) {
                //the Bank's account shows total amount of money that is stored in this Banking system.
                targetAccount.setBalance(-amount, this);
            }


        } else if (!transferSuccessful) {   //this is always true, but sanity check
            this.status = TransactionStatus.FAILURE;
        }
    }

    public TransactionStatus getStatus() {
        return status;
    }

    @Override
    public String toString(){
        String transactionType = isDeposit ? "DEPOSIT" : (isWithdrawal ? "WITHDRAWAL" : "TRANSFER");

        return
                transactionType + "\n"
                +"Transaction ID: " + this.id + "\n"
                +"Status: " + this.status + "\n"
                +"Source-Iban: " + this.source.toString() + "\n"
                +"Target-Iban: " + this.target.toString() + "\n"
                +"Amount: " + this.amount + "\n";
    }






}
