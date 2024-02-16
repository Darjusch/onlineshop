package src;

import java.util.NoSuchElementException;
import java.util.Scanner;

import src.menu.SignUpMenu;

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
        SignUpMenu signUpMenu = new SignUpMenu();

        while (true) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Select one of the following options by typing one of the numbers: ");
            if (signUpMenu.signedUp) {
                System.out.println(MAIN_MENU_TEXT_LOGGED_IN);

            } else {
                System.out.println(MAIN_MENU_TEXT_LOGGED_IN);

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
                            signUpMenu.signUp();
                            break;
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
