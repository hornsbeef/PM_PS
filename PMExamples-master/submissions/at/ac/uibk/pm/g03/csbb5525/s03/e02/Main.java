package at.ac.uibk.pm.g03.csbb5525.s03.e02;

/*
beim deposit sollte noch gecheckt werden, dass man keine negativen werte angeben kann!!



 */


public class Main {

    public static void main(String[] args) {

        //first create Banking System.
        Customer ownerErsteBankUndSparbuechse = new Customer("Balebub", "Balebab", CreditRating.LOW);
        BankingSystem ersteBankUndSparbuechse = new BankingSystem(ownerErsteBankUndSparbuechse, "AATX");

        //create customer:
        Customer customer1 = new Customer("Tinki", "Winky", CreditRating.HIGH);
        customer1.addBankAccounts(ersteBankUndSparbuechse.createAccount(customer1));


        Customer customer2 = new Customer("Asdf", "WSDA", CreditRating.LOW);
        customer2.addBankAccounts(ersteBankUndSparbuechse.createAccount(customer2));


        var c1b0 = customer1.getBankAccounts().getFirst();
        var c2b0 = customer2.getBankAccounts().getFirst();


        c1b0.deposit(10000);

        ersteBankUndSparbuechse.transfer(c1b0, c2b0, 5000);

        c2b0.withdraw(1000);


        ersteBankUndSparbuechse.printTransactions();

        ersteBankUndSparbuechse.printBankAccounts();
    }


}
