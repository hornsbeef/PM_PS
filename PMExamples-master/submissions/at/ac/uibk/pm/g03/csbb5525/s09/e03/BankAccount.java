package at.ac.uibk.pm.g03.csbb5525.s09.e03;

import java.math.BigDecimal;
import java.util.Objects;

public class BankAccount {
    private String IBAN;
    private String owner;
    private BigDecimal balance;

    public BankAccount(String IBAN, String owner, BigDecimal balance) {
        this.IBAN = IBAN;
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(BigDecimal amount){
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount){
        this.balance = this.balance.subtract(amount);
    }

    public String getAccountInfo(){
        return this.toString();
    }

    public String getIBAN() {
        return IBAN;
    }

    public String getOwner() {
        return owner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{IBAN='%s', owner='%s', balance=%s}".formatted(IBAN, owner, balance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount that)) return false;
        return Objects.equals(IBAN, that.IBAN) && Objects.equals(owner, that.owner) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IBAN, owner, balance);
    }



    public static class SavingsAccount extends BankAccount{
        public SavingsAccount(String IBAN, String owner, BigDecimal balance) {
            super(IBAN, owner, balance);
        }
        private static final BigDecimal INTEREST_RATE = BigDecimal.valueOf(20);


        @Override
        public void deposit(BigDecimal amount){
            super.deposit(amount.add(INTEREST_RATE));
        }

        @Override
        public void withdraw(BigDecimal amount){
            super.withdraw(amount);
        }
    }


    /*
     * Different approach to above:
     *  which one is better?
     *  probably to first one - less "duplicated" code
     *  Does this variant have any merits?
     */
    public static class GiroAccount extends BankAccount{
        //private final BigDecimal OVERDRAFT_FEE = BigDecimal.valueOf(15); bei BigDecimal besser den String-constructor!!
        private final BigDecimal OVERDRAFT_FEE = new BigDecimal("15");

        private BigDecimal balance;

        public GiroAccount(String IBAN, String owner, BigDecimal balance) {
            super(IBAN, owner, balance);
            this.balance = balance;
        }

        @Override
        public void withdraw(BigDecimal amount){
            if(this.balance.compareTo(amount) < 0){
                balance = balance.subtract(amount.add(OVERDRAFT_FEE));
            }
            else {
                balance = balance.subtract(amount);
            }
        }

        @Override
        public void deposit(BigDecimal amount){
            this.balance = this.balance.add(amount);
        }

        @Override
        public BigDecimal getBalance(){
            return this.balance;
        }

        @Override
        public String toString() {
            return "GiroAccount{IBAN='%s', owner='%s', balance=%s}".formatted(super.getIBAN(), super.getOwner(), balance);
        }
    }




}
