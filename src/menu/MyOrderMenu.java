package src.menu;

import src.enteties.Product;
import src.state.ApplicationContext;
import java.util.stream.Collectors;

public class MyOrderMenu implements Menu {

    ApplicationContext context;

    public MyOrderMenu(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void start() {
        if (context.getLoggedInUser() == null) {
            System.out.println("Please, log in or create new account to see list of your orders");
            return;
        }
        if (context.getPurchaseHistory().size() < 0) {
            System.out.println(
                    "Unfortunately, you don't have any orders yet. Navigate back to main menu to place a new order");
            return;
        }
        printMenuHeader();
        System.out.println("This is your Purchase History: ");
        String productsString = context.getPurchaseHistory().stream()
                .map(Product::toString)
                .collect(Collectors.joining(""));
        System.out.println(productsString);
        return;
    }

    @Override
    public void printMenuHeader() {
        System.out.println("**** My Order Menu ****");
    }

}
