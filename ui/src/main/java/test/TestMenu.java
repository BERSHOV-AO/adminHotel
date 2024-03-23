package test;

import menu.MenuController;
import ru.senla.guest.GuestsServiceImpl;
import ru.senla.room.RoomsServiceImpl;
import ru.senla.service.ServicesServiceImpl;
import ru.senla.stay_info.StayInfoServiceImpl;

public class TestMenu {

    public static void main(String[] args) {
        RoomsServiceImpl.getInstance().deserializeRooms();
        GuestsServiceImpl.getInstance().deserializeGuests();
        ServicesServiceImpl.getInstance().deserializeServices();
        StayInfoServiceImpl.getInstance().deserializeStayInfo();

        MenuController menuController = new MenuController();
        menuController.run();
    }
}
