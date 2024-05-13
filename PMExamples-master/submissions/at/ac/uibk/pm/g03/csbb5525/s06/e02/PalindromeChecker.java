package at.ac.uibk.pm.g03.csbb5525.s06.e02;

public class PalindromeChecker {

    public boolean isPalindrome(String sequence) {
        //ignore space
        //ignore symbols
        //check letters and numbers.


        String removedUnwantedCharacters = sequence.replaceAll("[^a-zA-Z0-9]", "");
        char[] sequ = removedUnwantedCharacters.toLowerCase().toCharArray();
        char[] reverse = new StringBuilder(removedUnwantedCharacters).reverse().toString().toLowerCase().toCharArray();


        boolean isequal = true;
        for(int i = 0; i < sequ.length; i++){
            if (sequ[i] != reverse[i]) {
                isequal = false;
                break;
            }
        }
        //would have been doable with makeing sequ and reverse a String -> and comparing with equals

        return isequal;

    }
}
