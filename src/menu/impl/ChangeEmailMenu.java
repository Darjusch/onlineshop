package src.menu.impl;

import java.util.Scanner;

import src.menu.Menu;
import src.state.ApplicationContext;

public class ChangeEmailMenu implements Menu {
    ApplicationContext context;

    public ChangeEmailMenu(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a new Email!");
        String userInput = sc.nextLine();
        context.getLoggedInUser().setUserEmail(userInput);
        System.out.println("Email changed successfully!");
    }

    @Override
    public void printMenuHeader() {
        System.out.println("**** CHANGE EMAIL *****");

    }

}
