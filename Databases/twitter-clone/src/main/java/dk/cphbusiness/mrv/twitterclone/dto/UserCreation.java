package dk.cphbusiness.mrv.twitterclone.dto;

public class UserCreation {
    public String username;
    public String firstname;
    public String lastname;
    public String passwordHash;
    public String birthday;

    public UserCreation(String username,
                        String firstname,
                        String lastname,
                        String passwordHash,
                        String birthday) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.passwordHash = passwordHash;
        this.birthday = birthday;
    }
}
