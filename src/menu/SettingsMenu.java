package src.menu;

import java.util.Scanner;

import src.state.ApplicationContext;

public class SettingsMenu implements Menu {
    private static final String SETTINGS_OPTIONS = """
            (1) Change Password
            (2) Change Email
            """;
    static final String MENU_STRING = "menu";

    ApplicationContext context;

    public SettingsMenu(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void start() {
        ChangePasswordMenu changePasswordMenu = new ChangePasswordMenu(context);
        ChangeEmailMenu changeEmailMenu = new ChangeEmailMenu(context);
        try {
            if (context.getLoggedInUser() == null) {
                System.out.println("Please, log in or create new account to change your account settings");
                return;
            }
            System.out.println(SETTINGS_OPTIONS);
            while (true) {
                System.out.println("Please select one of the options by typing either 1 or 2 and then press enter");
                Scanner sc = new Scanner(System.in);
                String userInput = sc.nextLine();
                if (userInput.equals(MENU_STRING)) {
                    return;
                }
                int userChoice = Integer.parseInt(userInput);
                switch (userChoice) {
                    case 1:
                        changePasswordMenu.start();
                        break;
                    case 2:
                        changeEmailMenu.start();
                    default:
                        System.out.println("Only 1, 2 is allowed. Try one more time");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Please select one of the options by typing either 1 or 2 and then press enter");
        }

    }

    @Override
    public void printMenuHeader() {
        System.out.println("**** SETTINGS *****");

    }

}
