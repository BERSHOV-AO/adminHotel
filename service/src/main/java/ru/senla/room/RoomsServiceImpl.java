package ru.senla.room;

import org.apache.log4j.Logger;
import ru.senla.entities.Room;
import ru.senla.guest.GuestsServiceImpl;
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

}
