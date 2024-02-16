package src.menu;

import java.util.NoSuchElementException;
import java.util.Scanner;

import src.enteties.DefaultUser;
import src.service.DefaultUserManagementService;

public class SignUpMenu {

    public boolean signedUp = false;

    public void signUp() {
        System.out.println("Welcome to the SignUp: ");
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
            System.out.println("New user is created");
            DefaultUser defaultUser = new DefaultUser(userFirstName, userLastName, userPassword,
                    userEmail);
            new DefaultUserManagementService().registerUser(defaultUser);
            this.signedUp = true;
            return;
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Please enter valid information");
            // e.printStackTrace();
        }
    }
}
