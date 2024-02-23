package src.menu.impl;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import src.enteties.Order;
import src.enteties.Product;
import src.enteties.impl.DefaultOrder;
import src.menu.Menu;
import src.service.OrderManagementService;
import src.service.ProductManagementService;
import src.state.ApplicationContext;

public class ProductCatalogMenu implements Menu {
    private ApplicationContext context;
    private ProductManagementService productManagementInstance;
    private OrderManagementService orderManagementInstance;

    public ProductCatalogMenu(ApplicationContext context, ProductManagementService productManagementInstance,
            OrderManagementService orderManagementInstance) {
        this.context = context;
        this.productManagementInstance = productManagementInstance;
        this.orderManagementInstance = orderManagementInstance;
    }

    @Override
    public void start() {
        printMenuHeader();
        Product[] products = productManagementInstance.getProducts();
        String productsString = Arrays.stream(products)
                .map(Product::toString)
                .collect(Collectors.joining(""));
        System.out.println(productsString);
        System.out.println(
                "Enter product id to add it to the cart or 'menu' if you want to navigate back to the main menu");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String userInput = sc.nextLine();
            if (userInput.equals("menu")) {
                return;
            } else if (userInput.equals("checkout")) {
                if (context.getLoggedInUser() == null) {
                    System.out.println("You are not logged in. Please, sign in or create new account");
                    return;
                } else if (context.getSessionCart().getProducts().length > 0) {
                    Order order = new DefaultOrder(1, context.getSessionCart().getProducts());
                    CheckoutMenu checkoutMenu = new CheckoutMenu(order, orderManagementInstance, context);
                    checkoutMenu.start();
                    return;
                } else {
                    System.out.println(
                            "Your cart is empty. Please, add product to cart first and then proceed with checkout");
                }
            }
            try {
                int id = Integer.parseInt(userInput);
                Product product = productManagementInstance.getProductById(id);
                if (product != null) {
                    context.getSessionCart().addProduct(product);
                    System.out.println("Product " + product.getProductName() + " has been added to your cart");
                    System.out.println("If you want to add a new product - enter the product id");
                    System.out.println("If you want to proceed with checkout - enter word 'checkout' to console");
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
