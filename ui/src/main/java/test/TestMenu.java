package test;

import action.room.PrintRoomsActionImpl;
import menu.Builder;
import menu.MenuController;
import ru.senla.ConfigurationType;
import ru.senla.DependencyInjector;
import ru.senla.annotations.ConfigProcessor;
import ru.senla.datasource.guest.GuestsDatasourceImpl;
import ru.senla.datasource.room.IRoomsDatasource;
import ru.senla.datasource.room.RoomsDatasourceImpl;
import ru.senla.datasource.room_history.RoomsHistoryDatasourceImpl;
import ru.senla.datasource.service.ServicesDatasourceImpl;
import ru.senla.datasource.stay_info.StayInfoDatasourceImpl;
//import ru.senla.di.Application;
//import ru.senla.di.ApplicationContext;
//import ru.senla.di_factory.ObjectFactory;
import ru.senla.di_factory.Application;
import ru.senla.di_factory.ApplicationContext;
import ru.senla.di_factory.ConfigLoader;
import ru.senla.di_factory.ObjectFactory;
import ru.senla.enums.RoomStatus;
import ru.senla.guest.GuestsServiceImpl;
import ru.senla.guest.IGuestsService;
import ru.senla.repository.guest.GuestsRepositoryImpl;
import ru.senla.repository.room.IRoomsRepository;
import ru.senla.repository.room.RoomsRepositoryImpl;
import ru.senla.repository.room_history.RoomsHistoryRepositoryImpl;
import ru.senla.repository.service.ServicesRepositoryImpl;
import ru.senla.repository.stay_info.StayInfoRepositoryImpl;
import ru.senla.room.IRoomsService;
import ru.senla.room.RoomsServiceImpl;
import ru.senla.service.IServicesService;
import ru.senla.service.ServicesServiceImpl;
import ru.senla.stay_info.IStayInfoService;
import ru.senla.stay_info.StayInfoServiceImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestMenu {

    public TestMenu() {

    }

    public static void main(String[] args) {

        ApplicationContext context = Application.run("ru.senla", ConfigLoader.loadConfig("resources/inject.properties"));
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
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        roomsService.deserializeRooms();
        roomsService.getListRooms().forEach(System.out::println);
        roomsService.addRoom(10,1,7555.0,3, RoomStatus.SERVICE);
        roomsService.getListRooms().forEach(System.out::println);
        servicesService.getListServices().forEach(System.out::println);

//        Builder builder = context.getObject(Builder.class);

      //  PrintRoomsActionImpl printRoomsAction = context.getObject(PrintRoomsActionImpl.class);
     //   printRoomsAction.execute();

        MenuController menuController = context.getObject(MenuController.class);
        menuController.getAppContext(context);
       menuController.run();
    }
}
