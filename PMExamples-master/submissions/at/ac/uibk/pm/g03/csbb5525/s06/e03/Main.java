package at.ac.uibk.pm.g03.csbb5525.s06.e03;

import java.time.DateTimeException;

public class Main {
    public static void main(String[] args) {
        PasswordChecker pwChecker = new PasswordChecker();
        try{
            User user = new User("a", "b", 31, 12, 1932);

            //testing:
            //System.out.println(pwChecker.checkPassword(user, "1_2asdfasdfasdfasdf").name());
        }catch(DateTimeException e){
            throw new DateTimeException("Wrong format in Birth-Date!\n" + e.getMessage());
        }







    }
}
