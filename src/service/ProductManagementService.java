package src.service;

import src.enteties.Product;

public interface ProductManagementService {

    Product[] getProducts();

    Product getProductById(int productIdToAddToCart);

}