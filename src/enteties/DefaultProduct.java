package src.enteties;

public class DefaultProduct implements Product {
    // TODO fix bug all products have ID 1
    private static int productCounter = 0; // Make it static

    int productId;
    String productName;
    String categoryName;
    double price;

    public DefaultProduct(String productName, String categoryName, double price) {
        this.productId = productCounter++; // Increment for each instance
        this.productName = productName;
        this.categoryName = categoryName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + "\n" +
                "Product Name: " + productName + "\n" +
                "Category Name: " + categoryName + "\n" +
                "Price: " + price + "\n" + "-----------" + "\n";
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
