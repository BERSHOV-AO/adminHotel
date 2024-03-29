package menu;

import java.util.List;

public class Navigator {

    private Menu currentMenu;

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public void printMenu() {
        System.out.println(currentMenu.getName());
        List<MenuItem> items = currentMenu.getMenuItems();
        for (int i = 0; i < items.size(); i++) {
            MenuItem item = items.get(i);
            System.out.println((i + 1) + ". " + item.getName());
        }
    }

    public void navigate(Integer index) {
        if (currentMenu.getMenuItems().get(index).getAction() != null) {
            currentMenu.getMenuItems().get(index).act();
        } else {
            currentMenu.getMenuItems().get(index).getNextMenu();
        }
    }
}
