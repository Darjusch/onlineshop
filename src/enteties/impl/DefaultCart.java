package src.enteties.impl;

import java.util.Arrays;

import src.enteties.Product;
import src.enteties.Cart;

public class DefaultCart implements Cart {

    private int productCounter = 0;
    private static int DEFAULT_CART_CAPACITY = 10;
    private Product[] cart = new Product[DEFAULT_CART_CAPACITY];

    public DefaultCart() {
    }

    @Override
    public void addProduct(Product productById) {
        if (productCounter >= cart.length) {
            int newCapacity = cart.length * 2;
            this.cart = Arrays.copyOf(cart, newCapacity);
        }
        this.cart[productCounter++] = productById;
        return;
    }

    @Override
    public void clear() {
        Arrays.fill(cart, 0, productCounter, null);
        productCounter = 0;
        return;
    }

    @Override
    public Product[] getProducts() {
        Product[] filteredRealProducts = Arrays.stream(cart).filter((product) -> product != null)
                .toArray(Product[]::new);
        return filteredRealProducts;
    }

    @Override
    public boolean isEmpty() {
        if (Arrays.stream(cart).filter((product) -> product != null).toArray(Product[]::new).length > 0) {
            return false;
        }
        return true;
    }

}
