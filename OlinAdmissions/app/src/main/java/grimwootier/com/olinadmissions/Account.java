package grimwootier.com.olinadmissions;

/**
 * Created by wooj on 11/2/14.
 */
public class Account {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String olinconnection;

    public Account(String username, String password, String firstname, String lastname, String olinconnection) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.olinconnection = olinconnection;
    }

    public String get_username() {
        return username;
    }

    public String get_password() {
        return password;
    }

    public String get_firstname() { return firstname; }

    public String get_lastname() { return lastname; }

    public String get_olinconnection() { return olinconnection; }
}