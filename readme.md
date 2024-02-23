=== Technical details ===

2. Each implementation of service should have this method

void clearServiceState()

for the sake of testing. This method should reset state of service to default. Taking into account the instance of each service will be in single copy, our tests have to have method that will clear the state of the service to reproduce different test cases.

To reset user counter - implement clearState() method in the DefaultUser class.

3. During implementation of this task you have to implement next interfaces:

public interface UserManagementService {

String registerUser(User user);

User[] getUsers();

User getUserByEmail(String userEmail);

}

And here is the class of ApplicationContext which will help you during implementation of this program:

public class ApplicationContext {

private static ApplicationContext instance;

private User loggedInUser;

private Menu mainMenu;

private Cart sessionCart;

private ApplicationContext() {

}

public void setLoggedInUser(User user) {

if (this.sessionCart != null) {

this.sessionCart.clear(); // we have to clear session cart when new user is logged in

}

this.loggedInUser = user;

}

public User getLoggedInUser() {

return this.loggedInUser;

}

public void setMainMenu(Menu menu) {

this.mainMenu = menu;

}

public Menu getMainMenu() {

return this.mainMenu;

}

public static ApplicationContext getInstance() {

if (instance == null) {

instance = new ApplicationContext();

}

return instance;

}

public Cart getSessionCart() {

if (this.sessionCart == null) {

this.sessionCart = new DefaultCart();

}

return this.sessionCart;

}

}
