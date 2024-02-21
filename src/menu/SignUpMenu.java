package src.menu;

import java.util.NoSuchElementException;
import java.util.Scanner;

import src.enteties.impl.DefaultUser;
import src.service.UserManagementService;
import src.state.ApplicationContext;

public class SignUpMenu implements Menu {

    private ApplicationContext context;
    private UserManagementService userManagementService;
    private Scanner scanner;

    public SignUpMenu(ApplicationContext context, UserManagementService userManagementService) {
        this.context = context;
        this.userManagementService = userManagementService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void start() {
        printMenuHeader();
        try {
            DefaultUser newUser = getUserDetailsFromInput();
            String message = userManagementService.registerUser(newUser);
            handleRegistrationResult(message, newUser);
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error processing sign-up. Please try again.");
        }
    }

    private DefaultUser getUserDetailsFromInput() {
        System.out.println("Please enter your first name: ");
        String userFirstName = scanner.nextLine();
        System.out.println("Please enter your last name: ");
        String userLastName = scanner.nextLine();
        System.out.println("Please enter your desired password: ");
        String userPassword = scanner.nextLine();
        System.out.println("Please enter your Email: ");
        String userEmail = scanner.nextLine();
        return new DefaultUser(userFirstName, userLastName, userPassword, userEmail);
    }

    private void handleRegistrationResult(String message, DefaultUser newUser) {
        if (message.equals("New user is created")) {
            context.setLoggedInUser(newUser);
        }
        System.out.println(message);
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** Sign Up *****");
    }
}
