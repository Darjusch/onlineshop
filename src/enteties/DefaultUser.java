package src.enteties;

public class DefaultUser implements User {

    int userCounter = 0;

    private int userId;
    String userFirstName;
    String userLastName;
    String userPassword;
    String userEmail;

    {
        userId = ++userCounter;
    }

    public DefaultUser(String userFirstName, String userLastName, String userPassword, String userEmail) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    @Override
    public String toString() {
        return "DefaultUser [userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", userPassword="
                + userPassword + ", userEmail=" + userEmail + "]";
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

}
