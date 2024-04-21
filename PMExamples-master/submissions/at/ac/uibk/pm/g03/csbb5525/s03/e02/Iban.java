package at.ac.uibk.pm.g03.csbb5525.s03.e02;

public class Iban {
    private int iban;

    private BankAccount bankAccount;


    public Iban(BankAccount bankAccount) {
        this.iban = bankAccount.hashCode();    //ignoring fact, that hashCollisions exist.
        this.bankAccount = bankAccount;
    }

    public BankAccount getIbanAccount() {
        return bankAccount;
    }

    @Override
    public String toString(){
        return Integer.toString(iban);
    }
}
