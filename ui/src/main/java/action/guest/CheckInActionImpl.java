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
import utils.InputReader;

import java.time.LocalDate;
import java.util.Scanner;

public class CheckInActionImpl implements IAction {
    final static Logger logger = Logger.getLogger(CheckInActionImpl.class);
    private IRoomsRepository roomsRepository = RoomsRepositoryImpl.getInstance();
    private IGuestsRepository guestsRepository = GuestsRepositoryImpl.getInstance();
    private IStayInfoRepository stayInfoRepository = StayInfoRepositoryImpl.getInstance();

    @Override
    public void execute() {
        if (roomsRepository.getEmptyRooms() == null) {
            System.out.println("Нет свободных номеров!");
            return;
        }

        if (guestsRepository.getAllGuests().size() == 0) {
            System.out.println("Нет доступных гостей!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("-------All Guests-------");
        guestsRepository.getAllGuests().stream().forEach(System.out::println);
        System.out.println("-------All Rooms-------");
        roomsRepository.getAllRooms().stream().forEach(System.out::println);

        int guestId = ExistsEntity.getExistsGuestID(guestsRepository);
        int roomId = ExistsEntity.getExistsRoomID(roomsRepository);
        LocalDate inDate = InputReader.getLocalDateInput(scanner,
                "Введите дату заселения в номер, пример \"YYYY-MM-DD\" ");
        LocalDate outDate = InputReader.getLocalDateInput(scanner,
                "Введите дату выселения из номера, пример \"YYYY-MM-DD\" ");
        try {
            stayInfoRepository.checkInGuestInRoom(guestsRepository.getGuestById(guestId),
                    roomsRepository.getRoomById(roomId), inDate, outDate);
            logger.info(String.format("Заселение гостя с id: %d, в номер с id: %d, дата заселения %s, дата выселения %s"
                    , guestId, roomId, inDate.toString(), outDate.toString()));
        } catch (Exception e) {
            System.out.println("Не удалось зарегистрировать посетителя! " + e.getMessage());
            logger.warn("Не удалось зарегистрировать посетителя! ", e);
        }
    }
}
