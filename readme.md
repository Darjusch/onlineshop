=== Technical details ===

General technical requirements:

1. instance of each service (UserManagementService, OrderManagementService, ProductManagementService, ApplicationContext) exist in a single copy during the program execution. Access to the single copy is possible via static getInstance() method of each specific type. And I can’t create objects of these types via constructor.

2. Each implementation of service should have this method

void clearServiceState()

for the sake of testing. This method should reset state of service to default. Taking into account the instance of each service will be in single copy, our tests have to have method that will clear the state of the service to reproduce different test cases.

To reset user counter - implement clearState() method in the DefaultUser class.

3. During implementation of this task you have to implement next interfaces:

public interface Cart {

boolean isEmpty();

void addProduct(Product productById);

Product[] getProducts();

void clear();

}

public interface Order {

boolean isCreditCardNumberValid(String userInput);

void setCreditCardNumber(String userInput);

void setProducts(Product[] products);

void setCustomerId(int customerId);

int getCustomerId();

}

public interface Product {

int getId();

String getProductName();

}

public interface User {

String getFirstName();

String getLastName();

String getPassword();

String getEmail();

int getId();

void setPassword(String newPassword);

void setEmail(String newEmail);

}

public interface Menu {

void start();

void printMenuHeader();

}

public interface OrderManagementService {

void addOrder(Order order);

Order[] getOrdersByUserId(int userId);

Order[] getOrders();

}

public interface ProductManagementService {

Product[] getProducts();

Product getProductById(int productIdToAddToCart);

}

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
