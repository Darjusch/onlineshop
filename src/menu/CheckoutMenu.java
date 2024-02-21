package src.menu;

import java.util.Scanner;

import src.enteties.Cart;
import src.enteties.Order;
import src.service.OrderManagementService;

public class CheckoutMenu implements Menu {
    private Order order;
    private Cart cart;
    private OrderManagementService orderManagementInstance;

    public CheckoutMenu(Order order, Cart cart, OrderManagementService orderManagementInstance) {
        this.order = order;
        this.cart = cart;
        this.orderManagementInstance = orderManagementInstance;
    }

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
                if (order.isCreditCardNumberValid(userInput)) {
                    order.setCreditCardNumber(userInput);
                    orderManagementInstance.addOrder(order);
                    cart.clear();
                    System.out.println(
                            "Thanks a lot for your purchase. Details about order delivery are sent to your email.");
                    return;
                } else {
                    System.out.println(
                            "You entered invalid credit card number. Valid credit card should contain between 8 and 19 digits. Please, try one more time.");
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