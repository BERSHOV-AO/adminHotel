package menu;

import room.AddRoomImpl;
import room.PrintEmptyRoomsImpl;
import room.PrintRoomsImpl;
import utils.MenuTypes;
import view.HotelManagerImpl;

public class Builder {

    private static final String action = MenuTypes.ACTION.getConstant();
    private static final String main = MenuTypes.MAIN_MENU.getConstant();

    private Menu roomMenu = new Menu(action);
    private Menu serviceMenu = new Menu(action);
    private Menu visitorMenu = new Menu(action);
    private Menu mainMenu = new Menu(main);

    public Builder() {
        HotelManagerImpl.getInstance();
    }

    public Menu buildMenu() {

        // Room

        roomMenu.addMenuItem(new MenuItem("Add a Room", roomMenu, new AddRoomImpl()));
        roomMenu.addMenuItem(new MenuItem("Print the Rooms", roomMenu, new PrintRoomsImpl()));
        roomMenu.addMenuItem(new MenuItem("Print empty Rooms", roomMenu, new PrintEmptyRoomsImpl()));
        roomMenu.addMenuItem(new MenuItem("Back to Main menu", mainMenu));


        // Main Menu
        mainMenu.addMenuItem(new MenuItem("Room Menu", roomMenu));

        return mainMenu;
    }


    public Menu getMenu() {
        return this.buildMenu();
    }
}

