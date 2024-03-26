package test;

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

//        ApplicationContext context =
//                Application.run("ru.senla", new HashMap<>(Map.of(
//                IRoomsDatasource.class, RoomsDatasourceImpl.class ,
//               IRoomsRepository.class, RoomsRepositoryImpl.class)));

//        Map<ConfigurationType, Object> configurationTypeObjectsMap = new HashMap<>();
//        configurationTypeObjectsMap.put(ConfigurationType.DATASOURCE_GUEST, GuestsDatasourceImpl.getInstance());
//        configurationTypeObjectsMap.put(ConfigurationType.DATASOURCE_ROOM, RoomsDatasourceImpl.getInstance());
//        configurationTypeObjectsMap.put(ConfigurationType.DATASOURCE_ROOM_HISTORY, RoomsHistoryDatasourceImpl.
//                getInstance());
//        configurationTypeObjectsMap.put(ConfigurationType.DATASOURCE_SERVICE, ServicesDatasourceImpl.getInstance());
//        configurationTypeObjectsMap.put(ConfigurationType.DATASOURCE_STAY_INFO, StayInfoDatasourceImpl.getInstance());
//        //-----------------------------------------------------------------------------------------------------------
//        configurationTypeObjectsMap.put(ConfigurationType.REPOSITORY_GUEST, GuestsRepositoryImpl.getInstance());
//        configurationTypeObjectsMap.put(ConfigurationType.REPOSITORY_ROOM, RoomsRepositoryImpl.getInstance());
//        configurationTypeObjectsMap.put(ConfigurationType.REPOSITORY_ROOM_HISTORY, RoomsHistoryRepositoryImpl
//                .getInstance());
//        configurationTypeObjectsMap.put(ConfigurationType.REPOSITORY_SERVICE, ServicesRepositoryImpl.getInstance());
//        configurationTypeObjectsMap.put(ConfigurationType.REPOSITORY_STAY_INFO, StayInfoRepositoryImpl.getInstance());
//        //-----------------------------------------------------------------------------------------------------------
//
//        configurationTypeObjectsMap.put(ConfigurationType.SERVICE_GUEST, GuestsServiceImpl.getInstance());
//        configurationTypeObjectsMap.put(ConfigurationType.SERVICE_ROOM, RoomsServiceImpl.getInstance());
//        configurationTypeObjectsMap.put(ConfigurationType.SERVICE_SERVICES, ServicesServiceImpl.getInstance());
//        configurationTypeObjectsMap.put(ConfigurationType.SERVICE_STAY_INFO, StayInfoServiceImpl.getInstance());
//
//        //-----------------------------------------------------------------------------------------------------------
//        DependencyInjector.injectDependencies(GuestsRepositoryImpl.getInstance(), configurationTypeObjectsMap);
//        DependencyInjector.injectDependencies(RoomsRepositoryImpl.getInstance(), configurationTypeObjectsMap);
//        DependencyInjector.injectDependencies(RoomsHistoryRepositoryImpl.getInstance(), configurationTypeObjectsMap);
//        DependencyInjector.injectDependencies(ServicesRepositoryImpl.getInstance(), configurationTypeObjectsMap);
//        DependencyInjector.injectDependencies(StayInfoRepositoryImpl.getInstance(), configurationTypeObjectsMap);
//        DependencyInjector.injectDependencies(GuestsServiceImpl.getInstance(), configurationTypeObjectsMap);
//        DependencyInjector.injectDependencies(RoomsServiceImpl.getInstance(), configurationTypeObjectsMap);
//        DependencyInjector.injectDependencies(ServicesServiceImpl.getInstance(), configurationTypeObjectsMap);
//        DependencyInjector.injectDependencies(StayInfoServiceImpl.getInstance(), configurationTypeObjectsMap);

        //----------------------------------------------------------------------------------------------------
//       // IRoomsService roomsService = ObjectFactory.getInstance().createObject(IRoomsService.class);
//        IRoomsService roomsService = RoomsServiceImpl.getInstance();
//       // IRoomsService roomsService = ObjectFactory.getInstance().createObject(IRoomsService.class);
//       IGuestsService guestsService = GuestsServiceImpl.getInstance();
//      //  IGuestsService guestsService = ObjectFactory.getInstance().createObject(IGuestsService.class);
//        try {
//            ConfigProcessor.processConfig(roomsService);
//            ConfigProcessor.processConfig(guestsService);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//
//        roomsService.deserializeRooms();
//        guestsService.deserializeGuests();
//        ServicesServiceImpl.getInstance().deserializeServices();
//        StayInfoServiceImpl.getInstance().deserializeStayInfo();


        ApplicationContext context = Application.run("ru.senla", ConfigLoader.loadConfig("resources/inject.properties"));
//        IGuestsService guestsService = context.getObject(IGuestsService.class);
        IRoomsService roomsService = context.getObject(IRoomsService.class);
        roomsService.deserializeRooms();
        roomsService.getListRooms().forEach(System.out::println);
        roomsService.addRoom(10,1,2.0,3, RoomStatus.SERVICE);
        roomsService.getListRooms().forEach(System.out::println);

//        IServicesService servicesService = context.getObject(IServicesService.class);
//       // IStayInfoService stayInfoService = context.getObject(IStayInfoService.class);

      //  MenuController menuController = context.getObject(MenuController.class);
        MenuController menuController = new MenuController();
        menuController.run();
    }
}
