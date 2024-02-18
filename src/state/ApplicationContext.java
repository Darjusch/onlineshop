package src.state;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

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
        Product[] filteredRealProducts = Arrays.stream(cart).filter((product) -> product != null)
                .toArray(Product[]::new);
        return filteredRealProducts;
    }

    public void addProductToCart(Product product) {
        if (cart.length >= productCounter) {
            this.cart = Arrays.copyOf(cart, cart.length + DEFAULT_CART_CAPACITY);
        }
        this.cart[productCounter] = product;
        productCounter++;
        return;
    }

    public void executeOrder() {
        for (int i = 0; i < productCounter; i++) {
            purchaseHistory.add(cart[i]);
        }
        clearCart();
    }

    private void clearCart() {
        Arrays.fill(cart, 0, productCounter, null);
        productCounter = 0;
    }

    private List<Product> purchaseHistory = new ArrayList<Product>();

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

    public List<Product> getPurchaseHistory() {
        return purchaseHistory;
    }

}
