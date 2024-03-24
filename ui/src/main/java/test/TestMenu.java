package test;

import menu.MenuController;
import ru.senla.annotations.ConfigProcessor;
import ru.senla.guest.GuestsServiceImpl;
import ru.senla.guest.IGuestsService;
import ru.senla.room.IRoomsService;
import ru.senla.room.RoomsServiceImpl;
import ru.senla.service.ServicesServiceImpl;
import ru.senla.stay_info.StayInfoServiceImpl;

import java.io.IOException;

public class TestMenu {



    public static void main(String[] args) {
        //  ApplicationContext context =  Application.run("ru.senla", new HashMap<>(Map.of(IGuestsDatasource.class, GuestsDatasourceImpl.class)));
       IRoomsService roomsService = RoomsServiceImpl.getInstance();
       IGuestsService guestsService = GuestsServiceImpl.getInstance();
        try {
            ConfigProcessor.processConfig(roomsService);
            ConfigProcessor.processConfig(guestsService);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        roomsService.deserializeRooms();
        guestsService.deserializeGuests();
        ServicesServiceImpl.getInstance().deserializeServices();
        StayInfoServiceImpl.getInstance().deserializeStayInfo();

        MenuController menuController = new MenuController();
        menuController.run();

    }
}
