package src.menu.impl;

import java.util.Scanner;

import src.enteties.User;
import src.enteties.impl.DefaultUser;
import src.menu.Menu;
import src.service.UserManagementService;
import src.state.ApplicationContext;

public class SignInMenu implements Menu {

    private ApplicationContext context;
    private UserManagementService userManagementService;

    public SignInMenu(ApplicationContext context, UserManagementService userManagementService) {
        this.context = context;
        this.userManagementService = userManagementService;
    }

    @Override
    public void start() {
        try {
            printMenuHeader();

            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter your Email");
            String userEmail = sc.nextLine();
            System.out.println("Please enter your Password");
            String userPassword = sc.nextLine();
            User user = new DefaultUser(userEmail, userPassword);

            String MESSAGE = userManagementService.loginUser(user);
            System.out.println(MESSAGE);
            if (MESSAGE.equals("Login successfull!")) {
                context.setLoggedInUser(user);
            }
            System.out.println(MESSAGE);
            return;
        } catch (Exception e) {
            System.out.println("Something was wrong with the input your provided.");
        }

    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** SIGN IN *****");
    }
}
