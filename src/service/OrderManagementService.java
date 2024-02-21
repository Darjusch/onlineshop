package src.service;

import src.enteties.Order;

public interface OrderManagementService {

    void addOrder(Order order);

    Order[] getOrdersByUserId(int userId);

    Order[] getOrders();
}