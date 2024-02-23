package src.service.impl;

import src.enteties.Order;
import src.service.OrderManagementService;
import java.util.Arrays;

public class DefaultOrderManagementService implements OrderManagementService {

    private int DEFAULT_ORDER_HISTORY_SIZE = 10;
    private int orderCounter = 0;
    private Order[] orderHistory = new Order[DEFAULT_ORDER_HISTORY_SIZE];

    private static DefaultOrderManagementService instance;

    private DefaultOrderManagementService() {

    }

    public static synchronized OrderManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultOrderManagementService();
        }
        return instance;
    }

    @Override
    public void addOrder(Order order) {
        if (isOrderHistoryFull()) {
            resizeOrderHistory();
        }
        orderHistory[orderCounter] = order;
        orderCounter++;
        return;
    }

    @Override
    public Order[] getOrders() {
        return Arrays.stream(orderHistory).filter((order) -> order != null).toArray(Order[]::new);
    }

    @Override
    public Order[] getOrdersByUserId(int userId) {
        return Arrays.stream(orderHistory).filter((order) -> order.getCustomerId() == userId).toArray(Order[]::new);
    }

    // For testing
    void clearServiceState() {
        orderCounter = 0;
        orderHistory = new Order[DEFAULT_ORDER_HISTORY_SIZE];
        instance = null;
        return;
    }

    private boolean isOrderHistoryFull() {
        return orderCounter == orderHistory.length;
    }

    private void resizeOrderHistory() {
        int newSize = orderHistory.length * 2;
        Order[] newOrderHistory = new Order[newSize];
        System.arraycopy(orderHistory, 0, newOrderHistory, 0, orderHistory.length);
        orderHistory = newOrderHistory;
    }

}
