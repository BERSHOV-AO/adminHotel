package action.guest;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.guest.GuestsServiceImpl;
import ru.senla.guest.IGuestsService;
import ru.senla.room.IRoomsService;
import ru.senla.room.RoomsServiceImpl;
import utils.InputReader;

import java.time.LocalDate;
import java.util.Scanner;

public class CheckInActionImpl implements IAction {
    final static Logger logger = Logger.getLogger(CheckInActionImpl.class);
    private static Scanner scanner = new Scanner(System.in);
    private IGuestsService guestsService = GuestsServiceImpl.getInstance();
    private IRoomsService roomsService = RoomsServiceImpl.getInstance();

    @Override
    public void execute() {

        try {
            System.out.println(guestsService.getListGuests());
            System.out.println(roomsService.getListRooms());

            int guestId = InputReader.getIntegerInput(scanner, "Введите id посетителя: ");
            int roomId = InputReader.getIntegerInput(scanner, "Введите id комнаты: ");

            LocalDate inDate = InputReader.getLocalDateInput(scanner,
                    "Введите дату заселения в номер, пример \"YYYY-MM-DD\" ");
            LocalDate outDate = InputReader.getLocalDateInput(scanner,
                    "Введите дату выселения из номера, пример \"YYYY-MM-DD\" ");
            System.out.println(guestsService.checkInGuest(guestId, roomId, inDate, outDate));

        } catch (Exception e) {
            System.out.println("Не удалось зарегистрировать посетителя! " + e.getMessage());
            logger.warn("Не удалось зарегистрировать посетителя! ", e);
        }
    }
}
