package menu;

import action.guest.*;
import action.room.*;
import action.service.*;
import action.sorted.room.*;

import action.sorted.guest.GuestSortServicesByPriceActionImpl;
import action.sorted.guest.GuestsSortByNameActionImpl;
import action.sorted.service.ServicesSortByNameActionImpl;
import action.sorted.service.ServicesSortByPriceActionImpl;
import action.stayInfo.ExportStayInfoActionImpl;
import action.stayInfo.ImportStayInfoActionImpl;
import action.stayInfo.PrintStayInfoActionImpl;
import controllers.guest.GuestManagerImpl;
import controllers.room.RoomManagerImpl;
import controllers.room_history.RoomHistoryManagerImpl;
import controllers.service.ServiceManagerImpl;
import controllers.stay_info.StayInfoManagerImpl;
import utils.MenuTypes;

public class Builder {

    private static final String action = MenuTypes.ACTION.getConstant();
    private static final String main = MenuTypes.MAIN_MENU.getConstant();

    private Menu roomMenu = new Menu(action);
    private Menu serviceMenu = new Menu(action);
    private Menu guestMenu = new Menu(action);
    private Menu mainMenu = new Menu(main);

    public Builder() {
        GuestManagerImpl.getInstance();
        RoomManagerImpl.getInstance();
        RoomHistoryManagerImpl.getInstance();
        ServiceManagerImpl.getInstance();
        StayInfoManagerImpl.getInstance();
    }

    public Menu buildMenu() {

        // Room
        roomMenu.addMenuItem(new MenuItem("Add a Room", roomMenu, new AddRoomActionImpl()));
        roomMenu.addMenuItem(new MenuItem("Print the Rooms", roomMenu, new PrintRoomsActionImpl()));
        roomMenu.addMenuItem(new MenuItem("Print empty Rooms", roomMenu, new PrintEmptyRoomsActionImpl()));
        roomMenu.addMenuItem(new MenuItem("Change Room Price", roomMenu, new ChangeRoomPriceActionImpl()));
        roomMenu.addMenuItem(new MenuItem("Change the Room's status", roomMenu, new ChangeStatusActionImpl()));
        roomMenu.addMenuItem(new MenuItem("Print the Room details", roomMenu, new PrintDetailsActionImpl()));
        // Room sort
        roomMenu.addMenuItem(new MenuItem("Sort the Rooms by capacity", roomMenu,
                new RoomsSortByCapacityActionImpl()));
        roomMenu.addMenuItem(new MenuItem("Sort the Rooms by price", roomMenu, new RoomsSortByPriceActionImpl()));
        roomMenu.addMenuItem(new MenuItem("Sort the Rooms by stars", roomMenu, new RoomsSortByStarsActionImpl()));
        roomMenu.addMenuItem(new MenuItem("Sort the empty Rooms by capacity", roomMenu,
                new RoomsSortEmptyByCapacityActionImpl()));
        roomMenu.addMenuItem(new MenuItem("Sort the empty Rooms by price", roomMenu,
                new RoomsSortEmptyByPriceActionImpl()));
        roomMenu.addMenuItem(new MenuItem("Sort the empty Rooms by stars", roomMenu,
                new RoomsSortEmptyByStarsActionImpl()));
        roomMenu.addMenuItem(new MenuItem("Export rooms to file CSV", roomMenu,
                new ExportRoomsActionImpl()));
        roomMenu.addMenuItem(new MenuItem("Import CSV files to Storage Rooms", roomMenu,
                new ImportRoomsActionImpl()));
        roomMenu.addMenuItem(new MenuItem("Back to Main menu", mainMenu));

        // Service
        serviceMenu.addMenuItem(new MenuItem("Add a Service", serviceMenu, new AddServiceActionImpl()));
        serviceMenu.addMenuItem(new MenuItem("Print the Services", serviceMenu, new PrintServiceActionImpl()));
        serviceMenu.addMenuItem(new MenuItem("Change the Service's price", serviceMenu,
                new ChangeServiceOnPriceActionImpl()));
        serviceMenu.addMenuItem(new MenuItem("Delete a Service", serviceMenu, new DeleteServiceActionImpl()));
        // Service sort
        serviceMenu.addMenuItem(new MenuItem("Sort the Services by name", serviceMenu,
                new ServicesSortByNameActionImpl()));
        serviceMenu.addMenuItem(new MenuItem("Sort the Services by price", serviceMenu,
                new ServicesSortByPriceActionImpl()));
        serviceMenu.addMenuItem(new MenuItem("Export services to file CSV", serviceMenu,
                new ExportServicesActionImpl()));
        serviceMenu.addMenuItem(new MenuItem("Import CSV files to Storage Services", serviceMenu,
                new ImportServicesActionImpl()));
        serviceMenu.addMenuItem(new MenuItem("Back to Main menu", mainMenu));

        // Guest
        guestMenu.addMenuItem(new MenuItem("Add a Guest", guestMenu, new AddGuestActionImpl()));
        guestMenu.addMenuItem(new MenuItem("Print the Guests", guestMenu, new PrintGuestsActionImpl()));
        guestMenu.addMenuItem(new MenuItem("Check-in the Guest", guestMenu, new CheckInActionImpl()));
        guestMenu.addMenuItem(new MenuItem("Add a Service to the Guest", guestMenu,
                new AddServicesToGuestActionImpl()));
        guestMenu.addMenuItem(new MenuItem("Print the Guest's Services", guestMenu,
                new PrintServicesOneGuestActionImpl()));
        guestMenu.addMenuItem(new MenuItem("Bill the Guest", guestMenu, new BillGuestActionImpl()));
        guestMenu.addMenuItem(new MenuItem("Check-out the Guest", guestMenu, new CheckOutActionImpl()));
        guestMenu.addMenuItem(new MenuItem("Delete the Guest", guestMenu, new DeleteGuestActionImpl()));

        // Guest sort
        guestMenu.addMenuItem(new MenuItem("Sort the Guest by name", guestMenu,
                new GuestsSortByNameActionImpl()));
        guestMenu.addMenuItem(new MenuItem("Sort the Guest's Services by price", guestMenu,
                new GuestSortServicesByPriceActionImpl()));
        guestMenu.addMenuItem(new MenuItem("Export guests to file CSV", guestMenu, new ExportGuestsActionImpl()));
        guestMenu.addMenuItem(new MenuItem("Import CSV files to Storage Guests", guestMenu,
                new ImportGuestsActionImpl()));
        guestMenu.addMenuItem(new MenuItem("Export StayInfo to File CSV", guestMenu,
                new ExportStayInfoActionImpl()));
//        guestMenu.addMenuItem(new MenuItem("Import CSV Files To StayInfo", guestMenu,
//                new ImportStayInfoActionImpl()));
        guestMenu.addMenuItem(new MenuItem("Print StayInfo", guestMenu,
                new PrintStayInfoActionImpl()));

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

