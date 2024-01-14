package menu;

import guest.*;
import room.AddRoomImpl;
import room.PrintEmptyRoomsImpl;
import room.PrintRoomsImpl;
import service.AddServiceImpl;
import service.ChangeServiceOnPriceImpl;
import service.DeleteServiceImpl;
import service.PrintServiceImpl;
import utils.MenuTypes;
import view.HotelManagerImpl;

public class Builder {

    private static final String action = MenuTypes.ACTION.getConstant();
    private static final String main = MenuTypes.MAIN_MENU.getConstant();

    private Menu roomMenu = new Menu(action);
    private Menu serviceMenu = new Menu(action);
    private Menu guestMenu = new Menu(action);
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

        // Service
        serviceMenu.addMenuItem(new MenuItem("Add a Service", serviceMenu, new AddServiceImpl()));
        serviceMenu.addMenuItem(new MenuItem("Print the Services", serviceMenu, new PrintServiceImpl()));
        serviceMenu.addMenuItem(new MenuItem("Change the Service's price", serviceMenu, new ChangeServiceOnPriceImpl()));
        serviceMenu.addMenuItem(new MenuItem("Delete a Service", serviceMenu, new DeleteServiceImpl()));
        serviceMenu.addMenuItem(new MenuItem("Back to Main menu", mainMenu));

        // Guest
        guestMenu.addMenuItem(new MenuItem("Add a Guest", guestMenu, new AddGuestImpl()));
        guestMenu.addMenuItem(new MenuItem("Print the Guests", guestMenu, new PrintGuestsImpl()));
        guestMenu.addMenuItem(new MenuItem("Check-in the Guest", guestMenu, new CheckInImpl()));
        guestMenu.addMenuItem(new MenuItem("Add a Service to the Guest", guestMenu, new AddServicesToGuestImpl()));
        guestMenu.addMenuItem(new MenuItem("Print the Guest's Services", guestMenu, new PrintServicesOneGuestImpl()));
        guestMenu.addMenuItem(new MenuItem("Bill the Guest", guestMenu, new BillGuestImpl()));
        guestMenu.addMenuItem(new MenuItem("Back to Main menu", mainMenu));

        // Main Menu
        mainMenu.addMenuItem(new MenuItem("Room Menu", roomMenu));
        mainMenu.addMenuItem(new MenuItem("Service Menu", serviceMenu));
        mainMenu.addMenuItem(new MenuItem("Guest Menu", guestMenu));
        mainMenu.addMenuItem(new MenuItem("Exit Program"));

        return mainMenu;
    }

    public Menu getMenu() {
        return this.buildMenu();
    }
}

