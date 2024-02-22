package ru.senla.stay_info;

import org.apache.log4j.Logger;
import ru.senla.entities.Service;
import ru.senla.entities.StayInfo;
import ru.senla.enums.GuestResponse;
import ru.senla.enums.RoomResponse;
import ru.senla.enums.StayInfoResponse;
import ru.senla.guest.GuestsServiceImpl;
import ru.senla.repository.guest.GuestsRepositoryImpl;
import ru.senla.repository.guest.IGuestsRepository;
import ru.senla.repository.room.IRoomsRepository;
import ru.senla.repository.room.RoomsRepositoryImpl;
import ru.senla.repository.stay_info.IStayInfoRepository;
import ru.senla.repository.stay_info.StayInfoRepositoryImpl;
import ru.senla.service.IServicesService;
import ru.senla.service.ServicesServiceImpl;

import java.util.List;
import java.util.Map;

public class StayInfoServiceImpl implements IStayInfoService {

    final static Logger logger = Logger.getLogger(StayInfoServiceImpl.class);
    private IStayInfoRepository stayInfoRepository = StayInfoRepositoryImpl.getInstance();
    private IGuestsRepository guestsRepository = GuestsRepositoryImpl.getInstance();
    private IRoomsRepository roomsRepository = RoomsRepositoryImpl.getInstance();

    private static StayInfoServiceImpl instance;

    private StayInfoServiceImpl() {
    }

    public static StayInfoServiceImpl getInstance() {
        if (instance == null) {
            instance = new StayInfoServiceImpl();
        }
        return instance;
    }

    @Override
    public Map<Integer, StayInfo> getMapStayInfo() {
        return stayInfoRepository.getMapStayInfo();
    }


    @Override
    public String getBillForIdRoomAndIdGuest(int guestId, int roomId) {

        if (!roomsRepository.checkRoomIDExists(roomId)) {
            return RoomResponse.ROOM_WITH_ID_DOES_NOT_EXIST.getMessage();
        }
        if (!guestsRepository.checkGuestIDExists(guestId)) {
            return GuestResponse.GUEST_WITH_ID_DOES_NOT_EXIST.getMessage();
        }

//        if (stayInfoRepository.isMapStayInfoEmpty()) {
//            return StayInfoResponse.NO_INFORMATION_STAY_INFO.getMessage();
//        } else {
//            Double bell = stayInfoRepository.getBillForRoomGuest(
//                    guestsRepository.getGuestById(guestId), roomsRepository.getRoomById(roomId));
//            return bell.toString();
//        }
        return null;
    }
}
