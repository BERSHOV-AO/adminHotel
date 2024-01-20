package menu;

import action.guest.*;
import action.room.*;
import action.sorted.room.*;

import action.service.AddServiceImpl;
import action.service.ChangeServiceOnPriceImpl;
import action.service.DeleteServiceImpl;
import action.service.PrintServiceImpl;
import action.sorted.guest.GuestSortServicesByPrice;
import action.sorted.guest.GuestsSortByNameImpl;
import action.sorted.service.ServicesSortByNameImpl;
import action.sorted.service.ServicesSortByPriceImpl;
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
        roomMenu.addMenuItem(new MenuItem("Change the Room's status", roomMenu, new ChangeStatusImpl()));
        roomMenu.addMenuItem(new MenuItem("Print the Room details", roomMenu, new PrintDetailsImpl()));
        // Room sort
        roomMenu.addMenuItem(new MenuItem("Sort the Rooms by capacity", roomMenu, new RoomsSortByCapacity()));
        roomMenu.addMenuItem(new MenuItem("Sort the Rooms by price", roomMenu, new RoomsSortByPrice()));
        roomMenu.addMenuItem(new MenuItem("Sort the Rooms by stars", roomMenu, new RoomsSortByStars()));
        roomMenu.addMenuItem(new MenuItem("Sort the empty Rooms by capacity", roomMenu,
                new RoomsSortEmptyByCapacity()));
        roomMenu.addMenuItem(new MenuItem("Sort the empty Rooms by price", roomMenu,
                new RoomsSortEmptyByPrice()));
        roomMenu.addMenuItem(new MenuItem("Sort the empty Rooms by stars", roomMenu,
                new RoomsSortEmptyByStars()));
        roomMenu.addMenuItem(new MenuItem("Back to Main menu", mainMenu));

        // Service
        serviceMenu.addMenuItem(new MenuItem("Add a Service", serviceMenu, new AddServiceImpl()));
        serviceMenu.addMenuItem(new MenuItem("Print the Services", serviceMenu, new PrintServiceImpl()));
        serviceMenu.addMenuItem(new MenuItem("Change the Service's price", serviceMenu,
                new ChangeServiceOnPriceImpl()));
        serviceMenu.addMenuItem(new MenuItem("Delete a Service", serviceMenu, new DeleteServiceImpl()));
        // Service sort
        serviceMenu.addMenuItem(new MenuItem("Sort the Services by name", serviceMenu,
                new ServicesSortByNameImpl()));
        serviceMenu.addMenuItem(new MenuItem("Sort the Services by price", serviceMenu,
                new ServicesSortByPriceImpl()));
        serviceMenu.addMenuItem(new MenuItem("Back to Main menu", mainMenu));

        // Guest
        guestMenu.addMenuItem(new MenuItem("Add a Guest", guestMenu, new AddGuestImpl()));
        guestMenu.addMenuItem(new MenuItem("Print the Guests", guestMenu, new PrintGuestsImpl()));
        guestMenu.addMenuItem(new MenuItem("Check-in the Guest", guestMenu, new CheckInImpl()));
        guestMenu.addMenuItem(new MenuItem("Add a Service to the Guest", guestMenu,
                new AddServicesToGuestImpl()));
        guestMenu.addMenuItem(new MenuItem("Print the Guest's Services", guestMenu,
                new PrintServicesOneGuestImpl()));
        guestMenu.addMenuItem(new MenuItem("Bill the Guest", guestMenu, new BillGuestImpl()));
        guestMenu.addMenuItem(new MenuItem("Check-out the Guest", guestMenu, new CheckOutImpl()));
        guestMenu.addMenuItem(new MenuItem("Delete the Guest", guestMenu, new DeleteGuestImpl()));

        // Guest sort
        guestMenu.addMenuItem(new MenuItem("Sort the Guest by name", guestMenu, new GuestsSortByNameImpl()));
        guestMenu.addMenuItem(new MenuItem("Sort the Guest's Services by price", guestMenu,
                new GuestSortServicesByPrice()));
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

