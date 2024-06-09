package at.ac.uibk.pm.g03.csbb5525.s09.e03;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class Bank {

    private final List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(AccountType accountType, String IBAN, String owner, BigDecimal balance){
        switch (accountType) {
            case SAVING -> {
                var temp = new BankAccount.SavingsAccount(IBAN, owner, balance);
                accounts.add(temp);
            }
            case GIRO -> {
                var temp = new BankAccount.GiroAccount(IBAN, owner, balance);
                accounts.add(temp);
            }
        }

    }

    public Optional<BankAccount> getAccount(String IBAN){
        if(IBAN == null){
            return Optional.empty(); // ? is this even needed?
        }
        return accounts.stream().filter(it -> it.getIBAN().equals(IBAN)).findFirst();
    }

    public void closeAccount(String IBAN){
        if(IBAN == null){
            return; // ? is this even needed?
        }
        else{
            accounts.removeIf(it-> IBAN.equals(it.getIBAN()));
        }
    }

    public void closeAccount(Predicate<BankAccount> predicate){
        if(predicate == null){
            return; // ? is this even needed?
        }
        else{
            accounts.removeIf(predicate);
        }
    }

    public List<String> getAllAccountsInfo(){
        return accounts.stream()
                       .map(BankAccount::getAccountInfo)
                       .toList();
    }

    public List<String> getAllAccountsInfo(Function<BankAccount, String> function){
        return accounts.stream()
                       .map(function)
                       .toList();
    }


    public List<BankAccount> getAccounts() {
        return accounts.stream().toList();
    }

    enum AccountType{
        SAVING,
        GIRO;
    }
}

