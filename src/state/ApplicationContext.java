package src.state;

import src.enteties.Cart;
import src.enteties.User;
import src.enteties.impl.DefaultCart;
import src.menu.Menu;

public class ApplicationContext {

    private static ApplicationContext instance;
    private User loggedInUser;
    private Menu mainMenu;
    private Cart sessionCart;

    private ApplicationContext() {

    }

    public static synchronized ApplicationContext getInstance() {
        if (instance == null) {
            instance = new ApplicationContext();
        }
        return instance;
    }

    public void setLoggedInUser(User user) {
        if (this.sessionCart != null) {

            this.sessionCart.clear(); // we have to clear session cart when new user is logged in

        }
        this.loggedInUser = user;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setMainMenu(Menu menu) {
        this.mainMenu = menu;
    }

    public Menu getMainMenu() {
        return this.mainMenu;
    }

    public Cart getSessionCart() {
        if (this.sessionCart == null) {
            this.sessionCart = new DefaultCart();
        }
        return this.sessionCart;

    }
}
