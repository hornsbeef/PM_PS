package at.ac.uibk.pm.g03.csbb5525.s04.e02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise2Application {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>(Arrays.asList(
                new User("user1", "password", "mail@ma.il", "0123456789"),
                new User("user2", "user2", "mail@ma.il", "0123456789"),
                new User("us", "password", "mail@ma.il", "0123456789"),
                new User("user4", "password", "mail@ma.il", null),
                new User("user5", "password", "", null)
        ));

        users.forEach( user -> {
            System.out.println("User " + user.getUsername() +  " Validation Status: " + UserValidator.userValid(user) ) ;
        });
    }
}

//due to exercise restrictions this implementation is not in its separate class and java-file.:
//otherwise would have put it in file UserValidator.java
//-> would it be better to pack this into a method?
class UserValidator implements Validator {

    //implements: checking if:
    //User has: valid Username AND valid Password AND valid phoneNumber OR valid mailAddress
    public static boolean userValid(User user) {
        Validator validator = new UserValidator();
        return validator.isValid(user);
    }


    @Override
    public boolean isValid(User user) {
        Validator usernameAndPassword = new AndValidator(new UsernameValidator(), new PasswordValidator());
        Validator phoneOrMail = new OrValidator(new PhoneNumberValidator(), new MailAddressValidator());
        return usernameAndPassword.isValid(user) && phoneOrMail.isValid(user);

    }
}