package src.state;

import src.enteties.User;

public class ApplicationContext {

    private static ApplicationContext instance;

    private ApplicationContext() {

    }

    public static synchronized ApplicationContext getInstance() {
        if (instance == null) {
            instance = new ApplicationContext();
        }
        return instance;
    }

    private User loggedInUser;

    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

}
