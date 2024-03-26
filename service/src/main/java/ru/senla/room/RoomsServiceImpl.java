package ru.senla.room;

import org.apache.log4j.Logger;
import ru.senla.ConfigurationType;
import ru.senla.InjectDependency;
import ru.senla.annotations.ConfigProperty;
import ru.senla.annotations.ConfigType;
//import ru.senla.di.InjectByType;
//import ru.senla.di_factory.ObjectFactory;
import ru.senla.di_factory.InjectByType;
import ru.senla.di_factory.ObjectFactory;
import ru.senla.di_factory.Singleton;
import ru.senla.entities.Room;
import ru.senla.enums.response.RoomResponse;
import ru.senla.enums.RoomStatus;
import ru.senla.repository.room.IRoomsRepository;
import ru.senla.repository.room.RoomsRepositoryImpl;

import java.util.List;

@Singleton
public class RoomsServiceImpl implements IRoomsService {

    @ConfigProperty(propertyName = "enable_room_status_change", type = ConfigType.BOOLEAN)
    private boolean RoomStatusChangeEnabled;

    final static Logger logger = Logger.getLogger(RoomsServiceImpl.class);

//    @InjectDependency(ConfigurationType.REPOSITORY_ROOM)
//    private IRoomsRepository roomsRepository;
//    @InjectByType
@InjectByType
private IRoomsRepository roomsRepository; // = ObjectFactory.getInstance().createObject(IRoomsRepository.class);

 //   private IRoomsRepository roomsRepository = RoomsRepositoryImpl.getInstance();





    private static RoomsServiceImpl instance;

    public RoomsServiceImpl() {
    }

    public static RoomsServiceImpl getInstance() {
        if (instance == null) {
            instance = new RoomsServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Room> getListRooms() {
        return roomsRepository.getAllRooms();
    }

    @Override
    public int getRoomNumberById(int roomId) {
        return roomsRepository.getRoomById(roomId).getRoomNumber();
    }

    @Override
    public String addRoom(int roomId, Integer capacity, Double priceDay, Integer stars, RoomStatus status) {
        try {
            if (roomsRepository.checkRoomIDExists(roomId)) {
                return RoomResponse.NUMBER_EXISTS_PLEASE_ENTER_ANOTHER_NUMBER.getMessage();
            }
            roomsRepository.addRoom(new Room(roomId, stars, priceDay, capacity, status));

            logger.info(String.format("Добавлена комната, номер: %d, количество звезд: %d, цена: %.2f," +
                    " вместимость: %d, статус: " + status, roomId, stars, priceDay, capacity));
            return RoomResponse.ROOM_ADDED.getMessage();
        } catch (Exception e) {
            logger.warn(RoomResponse.ERROR_ADDING_ROOM.getMessage(), e);
            return RoomResponse.ERROR_ADDING_ROOM.getMessage();
        }
    }

    @Override
    public String changeRoomPrice(int roomId, Double priceNew) {
        try {
            if (roomsRepository.checkRoomIDExists(roomId)) {
                roomsRepository.changeRoomPrice(roomsRepository.getRoomById(roomId), priceNew);
                logger.info(String.format("Стоимость номера с id %d, изменена на: %.2f", roomId, priceNew));
                return RoomResponse.ROOM_PRICE_CHANGE_OK.getMessage();
            } else {
                return RoomResponse.ROOM_WITH_ID_DOES_NOT_EXIST.getMessage();
            }
        } catch (Exception e) {
            logger.warn(RoomResponse.ERROR_ROOM_PRICE_CHANGE.getMessage(), e);
            return RoomResponse.ERROR_ROOM_PRICE_CHANGE.getMessage();
        }
    }

    @Override
    public String changeRoomStatus(int roomId, RoomStatus status) {


        try {
            if (RoomStatusChangeEnabled) {
                if (roomsRepository.checkRoomIDExists(roomId)) {
                    roomsRepository.changeRoomStatus(roomsRepository.getRoomById(roomId), status);
                    logger.info(String.format("Статус номера с id %d, изменена на: " + status, roomId));
                    return RoomResponse.ROOM_STATUS_CHANGED_OK.getMessage();
                } else {
                    return RoomResponse.ROOM_WITH_ID_DOES_NOT_EXIST.getMessage();
                }
            } else {
                return RoomResponse.DISABLE_CHANGE_STATUS_ROOM_IN_THE_SETTINGS.getMessage();
            }
        } catch (Exception e) {
            logger.warn(RoomResponse.ERROR_CHANGING_ROOM_STATUS.getMessage(), e);
            return RoomResponse.ERROR_CHANGING_ROOM_STATUS.getMessage();
        }
    }

    @Override
    public String exportRoomsToFileCSV() {
        try {
            if (roomsRepository.getAllRooms().isEmpty()) {
                logger.info(RoomResponse.EXPORT_ROOMS_NOK.getMessage());
                return RoomResponse.EXPORT_ROOMS_NOK.getMessage();
            } else {
                roomsRepository.exportRoomsToFileCSV();
                logger.info(RoomResponse.EXPORT_ROOMS_OK.getMessage());
                return RoomResponse.EXPORT_ROOMS_OK.getMessage();
            }
        } catch (Exception e) {
            logger.warn(RoomResponse.ERROR_EXPORT_ROOMS.getMessage(), e);
            return RoomResponse.ERROR_EXPORT_ROOMS.getMessage();
        }
    }

    @Override
    public String importCSVFilesToRooms() {
        try {
            roomsRepository.importCSVFilesToRooms();
            logger.info(RoomResponse.IMPORT_ROOMS_OK.getMessage());
            return RoomResponse.IMPORT_ROOMS_OK.getMessage();
        } catch (Exception e) {
            logger.warn(RoomResponse.ERROR_IMPORT_ROOMS.getMessage(), e);
            return RoomResponse.ERROR_IMPORT_ROOMS.getMessage();
        }
    }

    @Override
    public String printDetailsOneRoom(int roomId) {
        try {
            if (roomsRepository.checkRoomIDExists(roomId)) {
                return roomsRepository.getRoomDetails(roomsRepository.getRoomById(roomId));
            } else {
                return RoomResponse.ROOM_WITH_ID_DOES_NOT_EXIST.getMessage();
            }
        } catch (Exception e) {
            logger.warn(RoomResponse.ERROR_PRINT_ROOM_INFO.getMessage(), e);
            return RoomResponse.ERROR_PRINT_ROOM_INFO.getMessage();
        }
    }

    @Override
    public List<Room> printEmptyRooms() {
        return roomsRepository.getEmptyRooms();
    }

    @Override
    public List<Room> getListSortedRoomsByCapacity() {
        return roomsRepository.getSortedRoomsByCapacity();
    }

    @Override
    public List<Room> getListSortedRoomsByPrice() {
        return roomsRepository.getSortedRoomsByPrice();
    }

    @Override
    public List<Room> getListSortedRoomsByStars() {
        return roomsRepository.getSortedRoomsByStars();
    }

    @Override
    public List<Room> getListSortedEmptyRoomsByCapacity() {
        return roomsRepository.getFreeRooms(roomsRepository.getSortedRoomsByCapacity());
    }

    @Override
    public List<Room> getListSortedEmptyRoomsByPrice() {
        return roomsRepository.getFreeRooms(roomsRepository.getSortedRoomsByPrice());
    }

    @Override
    public List<Room> getListSortedEmptyRoomsByStars() {
        return roomsRepository.getFreeRooms(roomsRepository.getSortedRoomsByStars());
    }

    @Override
    public void serializerRooms() {
        roomsRepository.serializerRooms();
    }

    @Override
    public void deserializeRooms() {
        roomsRepository.deserializeRooms();
    }
}

