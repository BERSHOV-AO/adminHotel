package test;

import menu.MenuController;
import ru.senla.annotations.ConfigProcessor;
import ru.senla.di.Application;
import ru.senla.di.ApplicationContext;
import ru.senla.di.ConfigLoader;
import ru.senla.guest.IGuestsService;
import ru.senla.room.IRoomsService;
import ru.senla.service.IServicesService;
import ru.senla.stay_info.IStayInfoService;

import java.io.IOException;

public class TestMenu {

    public TestMenu() {

    }

    public static void main(String[] args) {

        ApplicationContext context = Application.run("ru.senla",
                ConfigLoader.loadConfig("resources/inject.properties"));
        IRoomsService roomsService = context.getObject(IRoomsService.class);
        IGuestsService guestsService = context.getObject(IGuestsService.class);
        IServicesService servicesService = context.getObject(IServicesService.class);
        IStayInfoService stayInfoService = context.getObject(IStayInfoService.class);

        roomsService.deserializeRooms();
        guestsService.deserializeGuests();
        servicesService.deserializeServices();
        stayInfoService.deserializeStayInfo();

        try {
            ConfigProcessor.processConfig(roomsService);
            ConfigProcessor.processConfig(guestsService);
        } catch (IllegalAccessException | IOException e) {
            throw new RuntimeException(e);
        }

        MenuController menuController = context.getObject(MenuController.class);
        menuController.getAppContext(context);
        menuController.run();
    }
}
