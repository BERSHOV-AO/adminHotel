package ru.senla.stay_info;

import org.apache.log4j.Logger;
import ru.senla.di.InjectByType;
import ru.senla.di.Singleton;
import ru.senla.entities.StayInfo;
import ru.senla.enums.response.GuestResponse;
import ru.senla.enums.response.RoomResponse;
import ru.senla.enums.response.StayInfoResponse;
import ru.senla.repository.guest.IGuestsRepository;
import ru.senla.repository.room.IRoomsRepository;
import ru.senla.repository.stay_info.IStayInfoRepository;

import java.util.Map;

@Singleton
public class StayInfoServiceImpl implements IStayInfoService {

    final static Logger logger = Logger.getLogger(StayInfoServiceImpl.class);

//    @InjectDependency(ConfigurationType.REPOSITORY_STAY_INFO)
//    private IStayInfoRepository stayInfoRepository;
//    @InjectDependency(ConfigurationType.REPOSITORY_GUEST)
//    private IGuestsRepository guestsRepository;
//
//    @InjectDependency(ConfigurationType.REPOSITORY_ROOM)
//    private IRoomsRepository roomsRepository;

//    private IStayInfoRepository stayInfoRepository = StayInfoRepositoryImpl.getInstance();
//    private IGuestsRepository guestsRepository = GuestsRepositoryImpl.getInstance();
//    private IRoomsRepository roomsRepository = RoomsRepositoryImpl.getInstance();

    @InjectByType
    private IStayInfoRepository stayInfoRepository; // = ObjectFactory.getInstance().createObject(IStayInfoRepository.class);
    @InjectByType
    private IGuestsRepository guestsRepository; // = ObjectFactory.getInstance().createObject(IGuestsRepository.class);

    @InjectByType
    private IRoomsRepository roomsRepository; // = ObjectFactory.getInstance().createObject(IRoomsRepository.class);

//    private static StayInfoServiceImpl instance;

    public StayInfoServiceImpl() {
    }

//    public static StayInfoServiceImpl getInstance() {
//        if (instance == null) {
//            instance = new StayInfoServiceImpl();
//        }
//        return instance;
//    }

    @Override
    public Map<Integer, StayInfo> getMapStayInfo() {
        return stayInfoRepository.getMapStayInfo();
    }


    @Override
    public String getBillForIdRoomAndIdGuest(int guestId, int roomId) {

        if (stayInfoRepository.getMapStayInfo().isEmpty()) {
            logger.warn(RoomResponse.ROOM_WITH_ID_DOES_NOT_EXIST.getMessage());
            return StayInfoResponse.NO_INFORMATION_STAY_INFO.getMessage();
        }
        if (!roomsRepository.checkRoomIDExists(roomId)) {
            logger.warn(RoomResponse.ROOM_WITH_ID_DOES_NOT_EXIST.getMessage());
            return RoomResponse.ROOM_WITH_ID_DOES_NOT_EXIST.getMessage();
        }
        if (!guestsRepository.checkGuestIDExists(guestId)) {
            logger.warn(GuestResponse.GUEST_WITH_ID_DOES_NOT_EXIST.getMessage());
            return GuestResponse.GUEST_WITH_ID_DOES_NOT_EXIST.getMessage();
        } else {
            StringBuilder str = new StringBuilder();
            str.append("************--BILL--************" + "\n");
            str.append("Имя гостя: " + guestsRepository.getGuestById(guestId).getLastName() + "\n");
            str.append("Номер комнаты: " + roomsRepository.getRoomById(roomId).getRoomNumber() + "\n");
            str.append("Счет за номер : ");
            str.append(stayInfoRepository.getBillForRoomAndGuest(guestsRepository.getGuestById(guestId),
                    roomsRepository.getRoomById(roomId)) + "руб." + "\n");
            str.append("********************************");
            logger.info(String.format("Гость с id: %d, номер с id: %d, счет за проживание равен: %.2f руб.",
                    guestId, roomId, stayInfoRepository.getBillForRoomGuest(
                            guestsRepository.getGuestById(guestId), roomsRepository.getRoomById(roomId))));
            return str.toString();
        }
    }

    @Override
    public String exportStayInfoToFileCSV() {

        try {
            if (stayInfoRepository.getMapStayInfo().isEmpty()) {
                logger.info(StayInfoResponse.EXPORT_STAY_INFO_NOK.getMessage());
                return StayInfoResponse.EXPORT_STAY_INFO_NOK.getMessage();
            } else {
                stayInfoRepository.exportStayInfoToFileCSV();
                logger.info(StayInfoResponse.EXPORT_STAY_INFO_OK.getMessage());
                return StayInfoResponse.EXPORT_STAY_INFO_OK.getMessage();
            }
        } catch (Exception e) {
            logger.warn(StayInfoResponse.ERROR_EXPORT_STAY_INFO.getMessage(), e);
            return (StayInfoResponse.ERROR_EXPORT_STAY_INFO.getMessage());
        }
    }

    @Override
    public Map<Integer, StayInfo> printStayInfo() {
        return stayInfoRepository.getMapStayInfo();
    }

    @Override
    public void serializerStayInfo() {
        stayInfoRepository.serializerStayInfo();
    }

    @Override
    public void deserializeStayInfo() {
        stayInfoRepository.deserializeStayInfo();
    }
}
