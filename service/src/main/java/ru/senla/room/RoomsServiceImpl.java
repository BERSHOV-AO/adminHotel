package ru.senla.room;

import org.apache.log4j.Logger;
import ru.senla.entities.Room;
import ru.senla.enums.RoomResponse;
import ru.senla.enums.RoomStatus;
import ru.senla.repository.room.IRoomsRepository;
import ru.senla.repository.room.RoomsRepositoryImpl;

import java.util.List;

public class RoomsServiceImpl implements IRoomsService {

    final static Logger logger = Logger.getLogger(RoomsServiceImpl.class);

    private IRoomsRepository roomsRepository = RoomsRepositoryImpl.getInstance();


    private static RoomsServiceImpl instance;

    private RoomsServiceImpl() {
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
}

