package src.menu;

import java.util.Scanner;

import src.state.ApplicationContext;

public class SettingsMenu implements Menu {
    private static final String SETTINGS_OPTIONS = """
            (1) Change Password
            (2) Change Email
            """;

    ApplicationContext context;

    public SettingsMenu(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void start() {
        ChangePasswordMenu changePasswordMenu = new ChangePasswordMenu(context);
        ChangeEmailMenu changeEmailMenu = new ChangeEmailMenu(context);
        try {
            System.out.println(SETTINGS_OPTIONS);
            Scanner sc = new Scanner(System.in);
            int optionSelected = sc.nextInt();
            switch (optionSelected) {
                case 1:
                    changePasswordMenu.start();
                    break;
                case 2:
                    changeEmailMenu.start();
                default:
                    break;
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
