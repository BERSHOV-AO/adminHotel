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
import action.stayInfo.PrintStayInfoActionImpl;
import ru.senla.di.ApplicationContext;
import utils.MenuTypes;

public class Builder {

    private ApplicationContext context;
    private static final String action = MenuTypes.ACTION.getConstant();
    private static final String main = MenuTypes.MAIN_MENU.getConstant();

    private Menu roomMenu = new Menu(action);
    private Menu serviceMenu = new Menu(action);
    private Menu guestMenu = new Menu(action);
    private Menu mainMenu = new Menu(main);

    public Builder() {
    }

    public Menu buildMenu() {

        // Room
        roomMenu.addMenuItem(new MenuItem("Add a Room", roomMenu,
                context.getObject(AddRoomActionImpl.class)));
        roomMenu.addMenuItem(new MenuItem("Print the Rooms", roomMenu,
                context.getObject(PrintRoomsActionImpl.class)));
        roomMenu.addMenuItem(new MenuItem("Print empty Rooms", roomMenu,
                context.getObject(PrintEmptyRoomsActionImpl.class)));
        roomMenu.addMenuItem(new MenuItem("Change Room Price", roomMenu,
                context.getObject(ChangeRoomPriceActionImpl.class)));
        roomMenu.addMenuItem(new MenuItem("Change the Room's status",
                roomMenu, context.getObject(ChangeStatusActionImpl.class)));
        roomMenu.addMenuItem(new MenuItem("Print the Room details", roomMenu,
                context.getObject(PrintDetailsActionImpl.class)));
        // Room sort
        roomMenu.addMenuItem(new MenuItem("Sort the Rooms by capacity", roomMenu,
                context.getObject(RoomsSortByCapacityActionImpl.class)));
        roomMenu.addMenuItem(new MenuItem("Sort the Rooms by price", roomMenu,
                context.getObject(RoomsSortByPriceActionImpl.class)));
        roomMenu.addMenuItem(new MenuItem("Sort the Rooms by stars", roomMenu,
                context.getObject(RoomsSortByStarsActionImpl.class)));
        roomMenu.addMenuItem(new MenuItem("Sort the empty Rooms by capacity", roomMenu,
                context.getObject(RoomsSortEmptyByCapacityActionImpl.class)));
        roomMenu.addMenuItem(new MenuItem("Sort the empty Rooms by price", roomMenu,
                context.getObject(RoomsSortEmptyByPriceActionImpl.class)));
        roomMenu.addMenuItem(new MenuItem("Sort the empty Rooms by stars", roomMenu,
                context.getObject(RoomsSortEmptyByStarsActionImpl.class)));
        roomMenu.addMenuItem(new MenuItem("Export rooms to file CSV", roomMenu,
                context.getObject(ExportRoomsActionImpl.class)));
        roomMenu.addMenuItem(new MenuItem("Import CSV files to Storage Rooms", roomMenu,
                context.getObject(ImportRoomsActionImpl.class)));
        roomMenu.addMenuItem(new MenuItem("Back to Main menu", mainMenu));

        // Service
        serviceMenu.addMenuItem(new MenuItem("Add a Service", serviceMenu,
                context.getObject(AddServiceActionImpl.class)));
        serviceMenu.addMenuItem(new MenuItem("Print the Services", serviceMenu,
                context.getObject(PrintServiceActionImpl.class)));
        serviceMenu.addMenuItem(new MenuItem("Change the Service's price", serviceMenu,
                context.getObject(ChangeServiceOnPriceActionImpl.class)));
        serviceMenu.addMenuItem(new MenuItem("Delete a Service", serviceMenu,
                context.getObject(DeleteServiceActionImpl.class)));
        // Service sort
        serviceMenu.addMenuItem(new MenuItem("Sort the Services by name", serviceMenu,
                context.getObject(ServicesSortByNameActionImpl.class)));
        serviceMenu.addMenuItem(new MenuItem("Sort the Services by price", serviceMenu,
                context.getObject(ServicesSortByPriceActionImpl.class)));
        serviceMenu.addMenuItem(new MenuItem("Export services to file CSV", serviceMenu,
                context.getObject(ExportServicesActionImpl.class)));
        serviceMenu.addMenuItem(new MenuItem("Import CSV files to Storage Services", serviceMenu,
                context.getObject(ImportServicesActionImpl.class)));
        serviceMenu.addMenuItem(new MenuItem("Back to Main menu", mainMenu));

        // Guest
        guestMenu.addMenuItem(new MenuItem("Add a Guest", guestMenu,
                context.getObject(AddGuestActionImpl.class)));
        guestMenu.addMenuItem(new MenuItem("Print the Guests", guestMenu,
                context.getObject(PrintGuestsActionImpl.class)));
        guestMenu.addMenuItem(new MenuItem("Check-in the Guest", guestMenu,
                context.getObject(CheckInActionImpl.class)));
        guestMenu.addMenuItem(new MenuItem("Add a Service to the Guest", guestMenu,
                context.getObject(AddServicesToGuestActionImpl.class)));
        guestMenu.addMenuItem(new MenuItem("Print the Guest's Services", guestMenu,
                context.getObject(PrintServicesOneGuestActionImpl.class)));
        guestMenu.addMenuItem(new MenuItem("Bill the Guest", guestMenu,
                context.getObject(BillGuestActionImpl.class)));
        guestMenu.addMenuItem(new MenuItem("Check-out the Guest", guestMenu,
                context.getObject(CheckOutActionImpl.class)));
        guestMenu.addMenuItem(new MenuItem("Delete the Guest", guestMenu,
                context.getObject(DeleteGuestActionImpl.class)));

        // Guest sort
        guestMenu.addMenuItem(new MenuItem("Sort the Guest by name", guestMenu,
                context.getObject(GuestsSortByNameActionImpl.class)));
        guestMenu.addMenuItem(new MenuItem("Sort the Guest's Services by price", guestMenu,
                context.getObject(GuestSortServicesByPriceActionImpl.class)));
        guestMenu.addMenuItem(new MenuItem("Export guests to file CSV", guestMenu,
                context.getObject(ExportGuestsActionImpl.class)));
        guestMenu.addMenuItem(new MenuItem("Import CSV files to Storage Guests", guestMenu,
                context.getObject(ImportGuestsActionImpl.class)));
        guestMenu.addMenuItem(new MenuItem("Export StayInfo to File CSV", guestMenu,
                context.getObject(ExportStayInfoActionImpl.class)));
        guestMenu.addMenuItem(new MenuItem("Print StayInfo", guestMenu,
                context.getObject(PrintStayInfoActionImpl.class)));
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

    public void getContext(ApplicationContext applicationContext) {
        this.context = applicationContext;
    }
}

