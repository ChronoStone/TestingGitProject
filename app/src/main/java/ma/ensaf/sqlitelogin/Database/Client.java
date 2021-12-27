package ma.ensaf.sqlitelogin.Database;

import java.util.Date;

public class Client {

    int id;
    String Login;
    String Password;
    Date LastLogin;

    public Client() {

    }

    public Client(int id, String login, String password, Date lastlogin) {
        this.id = id;
        this.Login = login;
        this.Password = password ;
        this.LastLogin = lastlogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Date getLastLogin() {
        return LastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        LastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "Client : " +
                "id=" + id +
                ", login ='" + Login + '\'' +
                ", password ='" + Password + '\'' +
                '}';
    }

}