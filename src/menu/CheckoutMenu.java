package src.menu;

import java.util.Scanner;

public class CheckoutMenu implements Menu {
    @Override
    public void start() {
        printMenuHeader();
        System.out.println("Enter your credit card number without spaces and press enter if you confirm purchase");
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String userInput = sc.nextLine();
                Integer.parseInt(userInput); // Only check if number
                // valid creditcard 8 to 19 digits
                if (userInput.length() >= 8 && userInput.length() <= 19) {
                    System.out.println(
                            "Thanks a lot for your purchase. Details about order delivery are sent to your email.");
                    return;
                } else {
                    System.out.println("Please enter a valid credit card number (8 to 19 digits) without spaces");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid credit card number (8 to 19 digits) without spaces");
            }
        }

    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** Checkout Menu *****");
    }
}