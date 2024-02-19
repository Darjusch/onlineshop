package src.menu;

import java.util.NoSuchElementException;
import java.util.Scanner;

import src.enteties.DefaultUser;
import src.service.DefaultUserManagementService;
import src.service.UserManagementService;
import src.state.ApplicationContext;

public class SignUpMenu implements Menu {

    ApplicationContext context;
    private UserManagementService userManagementService = DefaultUserManagementService.getInstance();

    public SignUpMenu(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void start() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Please enter your first name: ");
            String userFirstName = sc.nextLine();
            System.out.println("Please enter your last name: ");
            String userLastName = sc.nextLine();
            System.out.println("Please enter your desired password: ");
            String userPassword = sc.nextLine();
            System.out.println("Please enter your Email: ");
            String userEmail = sc.nextLine();
            DefaultUser defaultUser = new DefaultUser(userFirstName, userLastName, userPassword,
                    userEmail);
            String MESSAGE = userManagementService.registerUser(defaultUser);
            if (MESSAGE.equals("New user is created")) {
                context.setLoggedInUser(defaultUser);
            }
            System.out.println(MESSAGE);
            return;
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Please enter valid information");
            // e.printStackTrace();
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** Sign Up *****");

    }
}
