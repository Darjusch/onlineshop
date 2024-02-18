package src.state;

import java.util.Arrays;

import src.enteties.DefaultProduct;
import src.enteties.Product;
import src.enteties.User;

public class ApplicationContext {
    private User loggedInUser;
    // TODO should we keep this kere or in the ProductCatalogMenu since this is
    // static
    private Product[] products = {
            new DefaultProduct("Table", "Furniture", 200),
            new DefaultProduct("Bed", "Furniture", 250),
            new DefaultProduct("Chair", "Furniture", 30),
            new DefaultProduct("TV", "Electronic", 180),
            new DefaultProduct("Computer", "Electronic", 520),
    };
    private int productCounter = 0;
    private static int DEFAULT_CART_CAPACITY = 10;
    // Should we keep the cart in here? How to make this design decision?
    private Product[] cart = new Product[DEFAULT_CART_CAPACITY];

    public Product[] getCart() {
        return cart;
    }

    public void addProductToCart(Product product) {
        if (cart.length >= productCounter) {
            this.cart = Arrays.copyOf(cart, cart.length * 2);
        }
        this.cart[productCounter] = product;
        productCounter++;
        return;
    }

    public Product[] getProducts() {
        return products;
    }

    public Product getProduct(int id) {
        return Arrays.stream(products).filter((product) -> product.getProductId() == id).findFirst().orElse(null);
    }

    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

}
