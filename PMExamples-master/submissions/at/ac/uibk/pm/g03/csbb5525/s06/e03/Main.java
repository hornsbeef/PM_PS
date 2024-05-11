package at.ac.uibk.pm.g03.csbb5525.s06.e03;

public class Main {
    public static void main(String[] args) {
        PasswordChecker pwChecker = new PasswordChecker();

        User user;
        try{
            user = new User("Andreas", "Horninger", 2, 12, 1932);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("Check user-field input!\n" + e.getMessage());
        }

        try{
            System.out.println(pwChecker.checkPassword(user, "asdfAD").name());
        }catch(PasswordIllegalException e){
            throw new IllegalArgumentException("Check password guidelines!\n" + e.getMessage());
        }






    }
}
