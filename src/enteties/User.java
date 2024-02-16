package src.enteties;

public interface User {
    int getUserId();

    String getUserFirstName();

    String getUserLastName();

    String getUserPassword();

    String getUserEmail();

    void setUserPassword(String userPassword);

    void setUserEmail(String userEmail);
}