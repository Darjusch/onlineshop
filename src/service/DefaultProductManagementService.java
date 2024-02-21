package src.service;

import src.enteties.DefaultProduct;
import src.enteties.Product;
import java.util.Arrays;;

public class DefaultProductManagementService implements ProductManagementService {

    private static DefaultProductManagementService instance;

    private Product[] products = {
            new DefaultProduct("Table", "Furniture", 200),
            new DefaultProduct("Bed", "Furniture", 250),
            new DefaultProduct("Chair", "Furniture", 30),
            new DefaultProduct("TV", "Electronic", 180),
            new DefaultProduct("Computer", "Electronic", 520),
    };

    private DefaultProductManagementService() {
        // Private constructor to prevent instantiation from outside
    }

    public static synchronized DefaultProductManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultProductManagementService();
        }
        return instance;
    }

    @Override
    public Product[] getProducts() {
        return products;
    }

    @Override
    public Product getProductById(int id) {
        return Arrays.stream(products).filter((product) -> product.getProductId() == id).findFirst()
                .orElse(null);
    }
}
