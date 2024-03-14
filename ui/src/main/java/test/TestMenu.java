package test;

import menu.MenuController;
import ru.senla.enums.RoomStatus;
import ru.senla.guest.GuestsServiceImpl;
import ru.senla.room.IRoomsService;
import ru.senla.room.RoomsServiceImpl;
import ru.senla.service.ServicesServiceImpl;

public class TestMenu {

    public static void main(String[] args) {
        RoomsServiceImpl.getInstance().deserializeRooms();
        GuestsServiceImpl.getInstance().deserializeGuests();
        ServicesServiceImpl.getInstance().deserializeServices();

        MenuController menuController = new MenuController();
        menuController.run();
    }
}
