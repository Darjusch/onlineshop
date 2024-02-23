package src.menu.impl;

import java.util.NoSuchElementException;
import java.util.Scanner;

import src.exceptions.IncorrectNumberException;
import src.menu.Menu;
import src.service.OrderManagementService;
import src.service.ProductManagementService;
import src.service.UserManagementService;
import src.service.impl.DefaultOrderManagementService;
import src.service.impl.DefaultProductManagementService;
import src.service.impl.DefaultUserManagementService;
import src.state.ApplicationContext;

public class MainMenu implements Menu {
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

    public MainMenu() {

    }

    public void start() {
        UserManagementService userManagementServiceInstance = DefaultUserManagementService.getInstance();
        ProductManagementService productManagementInstance = DefaultProductManagementService.getInstance();
        OrderManagementService orderManagementInstance = DefaultOrderManagementService.getInstance();

        ApplicationContext context = ApplicationContext.getInstance();
        SignUpMenu signUpMenu = new SignUpMenu(context, userManagementServiceInstance);
        SignInMenu signInMenu = new SignInMenu(context, userManagementServiceInstance);
        SignOutMenu signOutMenu = new SignOutMenu(context);
        ProductCatalogMenu productCatalogMenu = new ProductCatalogMenu(context, productManagementInstance,
                orderManagementInstance);
        MyOrderMenu myOrderMenu = new MyOrderMenu(context, orderManagementInstance);
        SettingsMenu settingsMenu = new SettingsMenu(context);
        CustomerListMenu customerListMenu = new CustomerListMenu(userManagementServiceInstance);
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
                if (userChoice >= 1 && userChoice <= 6) {
                    switch (userChoice) {
                        case 1:
                            signUpMenu.start();
                            break;
                        case 2:
                            if (context.getLoggedInUser() == null) {
                                signInMenu.start();
                            } else {
                                signOutMenu.start();
                            }
                            break;
                        case 3:
                            productCatalogMenu.start();
                            break;
                        case 4:
                            myOrderMenu.start();
                            break;
                        case 5:
                            settingsMenu.start();
                            break;
                        case 6:
                            customerListMenu.start();
                            break;
                        default:
                            break;
                    }
                } else {
                    throw new IncorrectNumberException("The number has to be 1 >= and <= 6 : " + userInput);
                }
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("Please enter a valid number i.e. 1");
                // e.printStackTrace();
            } catch (IncorrectNumberException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("**** MAIN MENU ****");
    }
}
