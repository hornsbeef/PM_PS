package at.ac.uibk.pm.g03.csbb5525.s09.e03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {


    @Test
    public void createBank(){
        Bank bank = new Bank();
        assertNotNull(bank, "An instance of Bank should have been created...");
    }

    @Test
    public void addBankAccountsTest(){
        Bank bank = new Bank();
        bank.addAccount(Bank.AccountType.GIRO, "qwert", "Andreas", BigDecimal.TEN );
        bank.addAccount(Bank.AccountType.SAVING, "qwert1", "Johannes", BigDecimal.TEN );

        List<BankAccount> accounts = bank.getAccounts();

        assertAll(
                () -> assertEquals(2, accounts.size()),
                () -> assertEquals(new BankAccount.GiroAccount("qwert", "Andreas", BigDecimal.TEN ), accounts.get(0)),
                () -> assertEquals(new BankAccount.SavingsAccount("qwert1", "Johannes", BigDecimal.TEN ), accounts.get(1))
        );

    }

    @Test

    public void generalTest(){
        Bank bank = new Bank();
        bank.addAccount(Bank.AccountType.GIRO, "qwert", "Andreas", BigDecimal.TEN );
        bank.addAccount(Bank.AccountType.SAVING, "qwert1", "Johannes", BigDecimal.TEN );


        BankAccount a1 = bank.getAccount("qwert").orElseThrow(NoSuchElementException::new);
        BankAccount a2 = bank.getAccount("qwert1").orElseThrow(NoSuchElementException::new);
        Executable when1 = () -> bank.getAccount("no_such_IBAN").orElseThrow(NoSuchElementException::new);


        assertAll(
                () -> assertThrows(NoSuchElementException.class, when1),
                () -> assertEquals(List.of("Andreas", "Johannes"), bank.getAllAccountsInfo(BankAccount::getOwner))
                ,() -> {
                    a1.withdraw(BigDecimal.valueOf(11));
                    assertEquals(BigDecimal.valueOf(-16), a1.getBalance());
                },
                () -> {
                    a2.deposit(BigDecimal.ONE);
                    assertEquals(BigDecimal.valueOf(31), a2.getBalance());
                },
                () -> {
                    bank.closeAccount(it -> it.getOwner().equals("Andreas"));
                    assertEquals("Johannes", bank.getAllAccountsInfo(BankAccount::getOwner).get(0));
                }


        );

    }

}
