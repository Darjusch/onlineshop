package src.state;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import src.enteties.Product;
import src.enteties.User;

public class ApplicationContext {
    private User loggedInUser;

    private int productCounter = 0;
    private static int DEFAULT_CART_CAPACITY = 10;
    // Should we keep the cart in here? How to make this design decision?
    private Product[] cart = new Product[DEFAULT_CART_CAPACITY];

    public Product[] getCart() {
        Product[] filteredRealProducts = Arrays.stream(cart).filter((product) -> product != null)
                .toArray(Product[]::new);
        return filteredRealProducts;
    }

    public void addProductToCart(Product product) {
        // this includes the null values and therefore always is true and makes the
        // array really large fix this.
        if (cart.length >= productCounter) {
            this.cart = Arrays.copyOf(cart, cart.length + DEFAULT_CART_CAPACITY);
        }
        this.cart[productCounter] = product;
        productCounter++;
        return;
    }

    private void clearCart() {
        Arrays.fill(cart, 0, productCounter, null);
        productCounter = 0;
    }

    private List<Product> purchaseHistory = new ArrayList<Product>();

    public List<Product> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void executeOrder() {
        for (int i = 0; i < productCounter; i++) {
            purchaseHistory.add(cart[i]);
        }
        clearCart();
    }

    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

}
