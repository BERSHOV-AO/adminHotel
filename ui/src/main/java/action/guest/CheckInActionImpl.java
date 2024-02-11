package action.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;
import controllers.room.RoomManager;
import controllers.room.RoomManagerImpl;
import controllers.stay_info.StayInfoManagerImpl;
import org.apache.log4j.Logger;
import utils.ExistsEntity;
import utils.InputReader;

import java.time.LocalDate;
import java.util.Scanner;

public class CheckInActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(CheckInActionImpl.class);
    @Override
    public void execute() {

        RoomManager roomManager = RoomManagerImpl.getInstance();

        if (roomManager.getEmptyRooms() == null) {
            System.out.println("Нет свободных номеров!");
            return;
        }
        GuestManagerImpl guestManager = GuestManagerImpl.getInstance();
        if (guestManager.getAllGuests().size() == 0) {
            System.out.println("Нет доступных гостей!");
            return;
        }
        StayInfoManagerImpl stayInfoManager = StayInfoManagerImpl.getInstance();


        Scanner scanner = new Scanner(System.in);
        System.out.println("-------All Guests-------");
        guestManager.getAllGuests().stream().forEach(System.out::println);
        System.out.println("-------All Rooms-------");
        roomManager.getAllRooms().stream().forEach(System.out::println);

        int guestId = ExistsEntity.getExistsGuestID(guestManager);
        int roomId = ExistsEntity.getExistsRoomID(roomManager);
        LocalDate inDate = InputReader.getLocalDateInput(scanner,
                "Введите дату заселения в номер, пример \"YYYY-MM-DD\" ");
        LocalDate outDate = InputReader.getLocalDateInput(scanner,
                "Введите дату выселения из номера, пример \"YYYY-MM-DD\" ");
        try {
            stayInfoManager.checkInGuestInRoom(guestManager.getGuestById(guestId),
                    roomManager.getRoomById(roomId), inDate, outDate);
        } catch (Exception e) {
            System.out.println("Не удалось зарегистрировать посетителя! " + e.getMessage());
            logger.error("Не удалось зарегистрировать посетителя! ", e);
        }
    }
}
