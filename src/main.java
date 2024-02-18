package src;

import java.util.NoSuchElementException;
import java.util.Scanner;

import src.exceptions.IncorrectNumberException;
import src.menu.MyOrderMenu;
import src.menu.ProductCatalogMenu;
import src.menu.SignInMenu;
import src.menu.SignOutMenu;
import src.menu.SignUpMenu;
import src.state.ApplicationContext;

class Main {
    static final String EXIT_STRING = "exit";
    static final String MAIN_MENU_TEXT_LOGGED_IN = """
            (1) Sign Up
            (2) Sign Out
            (3) Product Catalog
            (4) My Orders
            (5) Settings
            (6) Customer List""";

    static final String MAIN_MENU_TEXT_NOT_LOGGED_IN = """
            (1) Sign Up
            (2) Sign In
            (3) Product Catalog
            (4) My Orders
            (5) Settings
            (6) Customer List""";

    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext();
        SignUpMenu signUpMenu = new SignUpMenu(context);
        SignInMenu signInMenu = new SignInMenu(context);
        SignOutMenu signOutMenu = new SignOutMenu(context);
        ProductCatalogMenu productCatalogMenu = new ProductCatalogMenu(context);
        MyOrderMenu myOrderMenu = new MyOrderMenu(context);
        while (true) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Select one of the following options by typing one of the numbers: ");
            if (context.getLoggedInUser() != null) {
                System.out.println(MAIN_MENU_TEXT_LOGGED_IN);
            } else {
                System.out.println(MAIN_MENU_TEXT_NOT_LOGGED_IN);
            }
            try {
                String userInput = sc.nextLine();
                if (userInput.equals(EXIT_STRING)) {
                    System.exit(0);
                }
                int userChoice = Integer.parseInt(userInput);
                if (userChoice >= 1 && userChoice <= 5) {
                    switch (userChoice) {
                        case 1:
                            signUpMenu.start();
                            break;
                        case 2:
                            System.out.println(context.getLoggedInUser());
                            if (context.getLoggedInUser() == null) {
                                signInMenu.start();
                            } else {
                                signOutMenu.start();
                            }
                        case 3:
                            productCatalogMenu.start();
                        case 4:
                            myOrderMenu.start();
                        default:
                            break;
                    }
                } else {
                    throw new IncorrectNumberException("The number has to be 1 >= and <= 5 : " + userInput);
                }
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("Please enter a valid number i.e. 1");
                // e.printStackTrace();
            } catch (IncorrectNumberException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
