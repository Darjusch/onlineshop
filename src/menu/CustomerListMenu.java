package src.menu;

import java.util.Arrays;
import java.util.stream.Collectors;

import src.enteties.User;
import src.service.UserManagementService;

public class CustomerListMenu implements Menu {
    private UserManagementService userManagementServiceInstance;

    public CustomerListMenu(UserManagementService userManagementServiceInstance) {
        this.userManagementServiceInstance = userManagementServiceInstance;
    }

    @Override
    public void start() {
        User[] users = userManagementServiceInstance.getUsers();
        String userString = Arrays.stream(users)
                .filter((user) -> user != null)
                .map(User::toString)
                .collect(Collectors.joining(""));
        System.out.println("Customer list: ");
        if (userString.length() == 0) {
            System.out.println("No customers yet!");
            return;
        }
        System.out.println(userString);
        return;
    }

    @Override
    public void printMenuHeader() {
        System.out.println("**** Customer List ****");
    }

}
