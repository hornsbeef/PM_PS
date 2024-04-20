package at.ac.uibk.pm.g03.csbb5525.s03.e02;

public class Main {

    public static void main(String[] args) {

        //first create Banking System.
        Customer ownerErsteBankUndSparbuechse = new Customer("Balebub", "Balebab", CreditRating.LOW);
        BankingSystem ersteBankUndSparbuechse = new BankingSystem(ownerErsteBankUndSparbuechse);

        //create customer:
        Customer customer1 = new Customer("Tinki", "Winky", CreditRating.HIGH);
        ersteBankUndSparbuechse.createAccount(customer1);







    }


}
