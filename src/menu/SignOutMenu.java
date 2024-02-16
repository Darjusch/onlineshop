package src.menu;

import src.state.ApplicationContext;

public class SignOutMenu implements Menu {

    ApplicationContext context;
    static final String LOGOUT_MESSAGE = "Have a nice day! Look forward to welcoming back!";

    public SignOutMenu(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void start() {
        context.setLoggedInUser(null);
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** Sign Out *****");
        System.out.println("Have a nice day! Look forward to welcoming back!");
    }
}
