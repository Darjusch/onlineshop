package src.menu.impl;

import src.enteties.Order;
import src.menu.Menu;
import src.service.OrderManagementService;
import src.state.ApplicationContext;
import java.util.stream.Collectors;
import java.util.Arrays;

public class MyOrderMenu implements Menu {

    private ApplicationContext context;
    private OrderManagementService orderManagementInstance;

    public MyOrderMenu(ApplicationContext context, OrderManagementService orderManagementService) {
        this.context = context;
        this.orderManagementInstance = orderManagementService;
    }

    @Override
    public void start() {
        if (context.getLoggedInUser() == null) {
            System.out.println("Please, log in or create new account to see list of your orders");
            return;
        }
        if (orderManagementInstance.getOrders()[0] == null) {
            System.out.println(
                    "Unfortunately, you don't have any orders yet. Navigate back to main menu to place a new order");
            return;
        }
        printMenuHeader();
        System.out.println("This is your Purchase History: ");
        String orderString = Arrays.stream(orderManagementInstance.getOrders())
                .map(Order::toString)
                .collect(Collectors.joining(""));
        System.out.println(orderString);
        return;
    }

    @Override
    public void printMenuHeader() {
        System.out.println("**** My Order Menu ****");
    }

}
