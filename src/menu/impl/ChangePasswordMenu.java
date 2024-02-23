package src.menu.impl;

import src.menu.Menu;
import src.state.ApplicationContext;
import java.util.Scanner;

public class ChangePasswordMenu implements Menu {
    ApplicationContext context;

    public ChangePasswordMenu(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void start() {
        try {
            printMenuHeader();
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter your new password");
            String password = sc.nextLine();
            System.out.println("New password: " + password);
            context.getLoggedInUser().setUserPassword(password);
            context.setLoggedInUser(context.getLoggedInUser());
            return;
        } catch (Exception e) {
            System.out.println("Please enter a valid password");
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("**** CHANGE PASSWORD ****");
    }

}
