package action.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;
import controllers.room.RoomManagerImpl;
import controllers.stay_info.StayInfoManagerImpl;
import utils.ExistsEntity;
import utils.InputReader;

import java.time.LocalDate;
import java.util.Scanner;

public class CheckInActionImpl implements IAction {
    @Override
    public void execute() {

        RoomManagerImpl roomManager = RoomManagerImpl.getInstance();

        if (roomManager.getEmptyRooms() == null) {
            System.out.println("Нет свободных номеров!");
            return;
        }
        StayInfoManagerImpl stayInfoManager = StayInfoManagerImpl.getInstance();
        GuestManagerImpl guestManager = GuestManagerImpl.getInstance();

        Scanner scanner = new Scanner(System.in);
        System.out.println("-------All Guests-------");
        guestManager.getAllGuests().stream().forEach(System.out::println);
        System.out.println("-------All Rooms-------");
        roomManager.getAllRooms().stream().forEach(System.out::println);

        int guestId = ExistsEntity.getExistsGuestID();
        int roomId = ExistsEntity.getExistsRoomID();
        LocalDate inDate = InputReader.getLocalDateInput(scanner,
                "Введите дату заселения в номер, пример \"YYYY-MM-DD\" ");
        LocalDate outDate = InputReader.getLocalDateInput(scanner,
                "Введите дату выселения из номера, пример \"YYYY-MM-DD\" ");
        try {
            stayInfoManager.checkInGuestInRoom(guestManager.getGuestById(guestId),
                    roomManager.getRoomById(roomId), inDate, outDate);
        } catch (Exception e) {
            System.out.println("Не удалось зарегистрировать посетителя! " + e.getMessage());
        }
    }
}
