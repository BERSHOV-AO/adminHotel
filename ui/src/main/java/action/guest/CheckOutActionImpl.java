package action.guest;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.repository.guest.GuestsRepositoryImpl;
import ru.senla.repository.guest.IGuestsRepository;
import ru.senla.repository.room.IRoomsRepository;
import ru.senla.repository.room.RoomsRepositoryImpl;
import ru.senla.repository.stay_info.IStayInfoRepository;
import ru.senla.repository.stay_info.StayInfoRepositoryImpl;
import utils.ExistsEntity;
import utils.Printer;

public class CheckOutActionImpl implements IAction {
    final static Logger logger = Logger.getLogger(CheckOutActionImpl.class);
    private IStayInfoRepository stayInfoRepository = StayInfoRepositoryImpl.getInstance();
    private IGuestsRepository guestsRepository = GuestsRepositoryImpl.getInstance();
    private IRoomsRepository roomsRepository = RoomsRepositoryImpl.getInstance();

    @Override
    public void execute() {
        if (ExistsEntity.noExistStayInfo(stayInfoRepository.getMapStayInfo())) {
            return;
        }

        Printer.printStayInfo(stayInfoRepository.getMapStayInfo());
        int guestId = ExistsEntity.getExistsGuestID(guestsRepository);
        int roomId = ExistsEntity.getExistsRoomID(roomsRepository);

        try {
            stayInfoRepository.checkOutGuestFromRoom(guestsRepository.getGuestById(guestId),
                    roomsRepository.getRoomByNumber(roomId));
            logger.info(String.format("Выселение гостя c id: %d, из номера с id: %d", guestId, roomId));
        } catch (Exception e) {
            System.out.println("Некорректный ввод данных " + e.getMessage());
            logger.warn("Не удалось выселить посетителя ", e);
        }
    }
}
