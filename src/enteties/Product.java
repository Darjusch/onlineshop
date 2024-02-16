package src.enteties;

public interface Product {
    int getProductId();

    String getProductName();

    String getCategoryName();

    double getPrice();

    void setProductName(String productName);

    void setCategoryName(String categoryName);

    void setPrice(double price);
}
