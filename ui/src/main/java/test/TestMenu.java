package test;

import menu.MenuController;
import ru.senla.ConfigurationType;
import ru.senla.DependencyInjector;
import ru.senla.annotations.ConfigProcessor;
import ru.senla.datasource.guest.GuestsDatasourceImpl;
import ru.senla.datasource.room.RoomsDatasourceImpl;
import ru.senla.datasource.room_history.RoomsHistoryDatasourceImpl;
import ru.senla.datasource.service.ServicesDatasourceImpl;
import ru.senla.datasource.stay_info.StayInfoDatasourceImpl;
import ru.senla.guest.GuestsServiceImpl;
import ru.senla.guest.IGuestsService;
import ru.senla.repository.guest.GuestsRepositoryImpl;
import ru.senla.repository.room.RoomsRepositoryImpl;
import ru.senla.repository.room_history.RoomsHistoryRepositoryImpl;
import ru.senla.repository.service.ServicesRepositoryImpl;
import ru.senla.repository.stay_info.StayInfoRepositoryImpl;
import ru.senla.room.IRoomsService;
import ru.senla.room.RoomsServiceImpl;
import ru.senla.service.ServicesServiceImpl;
import ru.senla.stay_info.StayInfoServiceImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestMenu {

    public TestMenu() {

    }

    public static void main(String[] args) {

        Map<ConfigurationType, Object> configurationTypeObjectsMap = new HashMap<>();
        configurationTypeObjectsMap.put(ConfigurationType.DATASOURCE_GUEST, GuestsDatasourceImpl.getInstance());
        configurationTypeObjectsMap.put(ConfigurationType.DATASOURCE_ROOM, RoomsDatasourceImpl.getInstance());
        configurationTypeObjectsMap.put(ConfigurationType.DATASOURCE_ROOM_HISTORY, RoomsHistoryDatasourceImpl.
                getInstance());
        configurationTypeObjectsMap.put(ConfigurationType.DATASOURCE_SERVICE, ServicesDatasourceImpl.getInstance());
        configurationTypeObjectsMap.put(ConfigurationType.DATASOURCE_STAY_INFO, StayInfoDatasourceImpl.getInstance());
        //-----------------------------------------------------------------------------------------------------------
        configurationTypeObjectsMap.put(ConfigurationType.REPOSITORY_GUEST, GuestsRepositoryImpl.getInstance());
        configurationTypeObjectsMap.put(ConfigurationType.REPOSITORY_ROOM, RoomsRepositoryImpl.getInstance());
        configurationTypeObjectsMap.put(ConfigurationType.REPOSITORY_ROOM_HISTORY, RoomsHistoryRepositoryImpl
                .getInstance());
        configurationTypeObjectsMap.put(ConfigurationType.REPOSITORY_SERVICE, ServicesRepositoryImpl.getInstance());
        configurationTypeObjectsMap.put(ConfigurationType.REPOSITORY_STAY_INFO, StayInfoRepositoryImpl.getInstance());
        //-----------------------------------------------------------------------------------------------------------

        configurationTypeObjectsMap.put(ConfigurationType.SERVICE_GUEST, GuestsServiceImpl.getInstance());
        configurationTypeObjectsMap.put(ConfigurationType.SERVICE_ROOM, RoomsServiceImpl.getInstance());
        configurationTypeObjectsMap.put(ConfigurationType.SERVICE_SERVICES, ServicesServiceImpl.getInstance());
        configurationTypeObjectsMap.put(ConfigurationType.SERVICE_STAY_INFO, StayInfoServiceImpl.getInstance());

        //-----------------------------------------------------------------------------------------------------------
        DependencyInjector.injectDependencies(GuestsRepositoryImpl.getInstance(), configurationTypeObjectsMap);
        DependencyInjector.injectDependencies(RoomsRepositoryImpl.getInstance(), configurationTypeObjectsMap);
        DependencyInjector.injectDependencies(RoomsHistoryRepositoryImpl.getInstance(), configurationTypeObjectsMap);
        DependencyInjector.injectDependencies(ServicesRepositoryImpl.getInstance(), configurationTypeObjectsMap);
        DependencyInjector.injectDependencies(StayInfoRepositoryImpl.getInstance(), configurationTypeObjectsMap);
        DependencyInjector.injectDependencies(GuestsServiceImpl.getInstance(), configurationTypeObjectsMap);
        DependencyInjector.injectDependencies(RoomsServiceImpl.getInstance(), configurationTypeObjectsMap);
        DependencyInjector.injectDependencies(ServicesServiceImpl.getInstance(), configurationTypeObjectsMap);
        DependencyInjector.injectDependencies(StayInfoServiceImpl.getInstance(), configurationTypeObjectsMap);

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
