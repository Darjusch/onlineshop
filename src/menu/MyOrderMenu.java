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
