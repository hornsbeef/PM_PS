package at.ac.uibk.pm.g03.csbb5525.s04.e02;

public class MailAddressValidator implements Validator{

    public boolean isValid(User user){
        //return user.getMailAddress().contains("@");   //-> only checks if it is contained at all, not if only once.
        int count = 0;
        for(char c : user.getMailAddress().toCharArray()){
            if(c =='@'){
                count++;
            }
        }
        return count == 1;


    }
}
