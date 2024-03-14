package test;

import menu.MenuController;
import ru.senla.enums.RoomStatus;
import ru.senla.room.IRoomsService;
import ru.senla.room.RoomsServiceImpl;

public class TestMenu {

    public static void main(String[] args) {
        IRoomsService roomsService = RoomsServiceImpl.getInstance();
        roomsService.deserializeRooms();

        MenuController menuController = new MenuController();
        menuController.run();
    }
}
