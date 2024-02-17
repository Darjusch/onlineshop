package src.menu;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import src.enteties.Product;
import src.state.ApplicationContext;

public class ProductCatalogMenu implements Menu {
    ApplicationContext context;

    public ProductCatalogMenu(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void start() {
        printMenuHeader();
        Product[] products = context.getProducts();
        String productsString = Arrays.stream(products)
                .map(Product::toString)
                .collect(Collectors.joining(""));
        System.out.println(productsString);
        System.out.println(
                "Enter product id to add it to the cart or 'menu' if you want to navigate back to the main menu");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String userInput = sc.nextLine();
            if (userInput == "menu" || userInput == "checkout") {
                return;
            }
            try {
                int id = Integer.parseInt(userInput);
                Product product = context.getProduct(id);
                if (product != null) {
                    System.out.println("Product " + product.getProductName() + " has been added to your cart");
                    System.out.println("If you want to add a new product - enter the product id");
                    System.out.println("If you want to proceed with checkout - enter word 'checkout' to console");
                    // TODO Add product to Cart
                } else {
                    System.out.println("Please, enter product ID if you want to add product to cart.");
                    System.out.println("Or enter 'checkout' if you want to proceed with checkout.");
                    System.out.println("Or enter 'menu' if you want to navigate back to the main menu.");
                }
            } catch (Exception e) {
                System.out.println("Please only enter valid id's, 'menu' or 'checkout'");
            }
            System.out.println(productsString);
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** Product Catalog Menu *****");
    }
}
