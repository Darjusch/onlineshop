package src.menu;

public class MyOrderMenu implements Menu {

    @Override
    public void start() {
        printMenuHeader();

    }

    @Override
    public void printMenuHeader() {
        System.out.println("**** My Order Menu ****");
    }

}
