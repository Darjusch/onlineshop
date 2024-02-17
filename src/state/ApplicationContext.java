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
