package dk.cphbusiness.mrv.twitterclone.dto;

public class UserUpdate {
    public String username;
    public String firstname; // if null, don't update
    public String lastname; // if null, don't update
    public String birthday; // if null, don't update

    public UserUpdate(String username, String firstname, String lastname, String birthday) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
    }
}
