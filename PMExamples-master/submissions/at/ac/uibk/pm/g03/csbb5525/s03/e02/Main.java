package at.ac.uibk.pm.g03.csbb5525.s03.e02;

public class Main {

    public static void main(String[] args) {

        //first create Banking System.
        Customer ownerErsteBankUndSparbuechse = new Customer("Balebub", "Balebab", CreditRating.LOW);
        BankingSystem ersteBankUndSparbuechse = new BankingSystem(ownerErsteBankUndSparbuechse);

        //create customer:
        Customer customer1 = new Customer("Tinki", "Winky", CreditRating.HIGH);
        ersteBankUndSparbuechse.createAccount(customer1);

        Customer customer2 = new Customer("Asdf", "WSDA", CreditRating.LOW);
        ersteBankUndSparbuechse.createAccount(customer2);



        BankAccount c1b0 = saveGetBankAccount(customer1, ersteBankUndSparbuechse, 0);
        BankAccount c2b0 = saveGetBankAccount(customer2, ersteBankUndSparbuechse, 0);
        c1b0.deposit(10000);
        ersteBankUndSparbuechse.transfer(c1b0.getIban(), c2b0.getIban(), 5000);
        c2b0.withdraw(1000);


        BankAccount doesNotExist = saveGetBankAccount(customer2, ersteBankUndSparbuechse, 3);
        doesNotExist.withdraw(10000);   //still works because of credit score
        doesNotExist.withdraw(1);       //this now fails, due to credit score


        ersteBankUndSparbuechse.printTransactions();

        ersteBankUndSparbuechse.printBankAccounts();


    }

    private static BankAccount saveGetBankAccount(Customer customer1, BankingSystem ersteBankUndSparbuechse, int index) {
        while(true){    //sanity
            BankAccount c1b1;
            if(customer1.getBankAccount(customer1, ersteBankUndSparbuechse,index).isPresent()){
                c1b1 = customer1.getBankAccount(customer1, ersteBankUndSparbuechse,index).get();
                return c1b1;
            }
        }
    }


}
