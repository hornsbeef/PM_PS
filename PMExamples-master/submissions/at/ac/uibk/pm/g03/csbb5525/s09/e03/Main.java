package at.ac.uibk.pm.g03.csbb5525.s09.e03;

import at.ac.uibk.pm.g03.csbb5525.s04.e03.B;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount.SavingsAccount("1234", "Andy", BigDecimal.ONE);
        System.out.println(bankAccount.getAccountInfo());

        bankAccount.deposit(BigDecimal.ONE);

        bankAccount.withdraw(BigDecimal.ONE);
        System.out.println(bankAccount.getAccountInfo());

        System.out.println(bankAccount.getClass());


        BankAccount.GiroAccount ba2 = new BankAccount.GiroAccount("1234", "Andy", BigDecimal.ONE);

        ba2.withdraw(BigDecimal.TEN);
        System.out.println(ba2.getAccountInfo());

        ba2.deposit(BigDecimal.ONE);
        System.out.println(ba2.getAccountInfo());

        System.out.println(bankAccount.getBalance() + bankAccount.getOwner() + bankAccount.getIBAN());
        System.out.println(ba2.getBalance() + ba2.getOwner() + ba2.getIBAN());

        Bank bank = new Bank();
        bank.addAccount(Bank.AccountType.GIRO, "12345", "Andy", BigDecimal.TEN);
        bank.closeAccount("12345");



    }

}
