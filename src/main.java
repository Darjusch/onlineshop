package src;

import src.menu.Menu;
import src.menu.impl.MainMenu;

class Main {

    public static void main(String[] args) {
        Menu mainMenu = new MainMenu();
        mainMenu.start();
    }
}
