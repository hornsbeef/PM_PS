package at.ac.uibk.pm.g03.csbb5525.s04.e02;

public class User {
    private final String username;
    private final String password;
    private final String mailAddress;
    private final String phoneNumber;

    public User(String username, String password, String mailAddress, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.mailAddress = mailAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
