import java.util.NoSuchElementException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        SignUpMenu signUpMenu = new SignUpMenu();
        String mainMenuText;
        while (true) {
            if (signUpMenu.signedUp) {
                mainMenuText = """
                        (1) Sign Up
                        (2) Sign Out
                        (3) Product Catalog
                        (4) My Orders
                        (5) Settings
                        (6) Customer List""";
            } else {
                mainMenuText = """
                        (1) Sign Up
                        (2) Sign In / Sign Out
                        (3) Product Catalog
                        (4) My Orders
                        (5) Settings
                        (6) Customer List""";
            }
            Scanner sc = new Scanner(System.in);
            System.out.println("Select one of the following options by typing one of the numbers: ");
            System.out.println(mainMenuText);
            try {
                int userInput = sc.nextInt();
                if (userInput >= 1 && userInput <= 6) {
                    switch (userInput) {
                        case 1:
                            signUpMenu.signUp();
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
}
