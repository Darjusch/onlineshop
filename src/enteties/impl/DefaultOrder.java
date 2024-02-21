package src.enteties.impl;

import java.util.Arrays;

import src.enteties.Order;
import src.enteties.Product;

public class DefaultOrder implements Order {
    private int customerId;
    private String creditCardNumber;
    private Product[] products;

    public DefaultOrder(int customerId, Product[] products) {
        this.customerId = customerId;
        this.products = products;
    }

    @Override
    public int getCustomerId() {
        return this.customerId;
    }

    @Override
    public String toString() {
        return "DefaultOrder [customerId=" + customerId + ", products=" + Arrays.toString(products) + "]";
    }

    @Override
    public boolean isCreditCardNumberValid(String userInput) {
        if (userInput.length() >= 8 && userInput.length() <= 19) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setCreditCardNumber(String userInput) {
        if (isCreditCardNumberValid(userInput)) {
            this.creditCardNumber = userInput;
        }
        return;
    }

    @Override
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
        return;
    }

    @Override
    public void setProducts(Product[] products) {
        this.products = products;
        return;
    }

}
