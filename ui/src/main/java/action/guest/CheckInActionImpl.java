package action.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;
import controllers.room.RoomManagerImpl;
import controllers.stay_info.StayInfoManagerImpl;
import utils.InputReader;

import java.time.LocalDate;
import java.util.Scanner;

public class CheckInActionImpl implements IAction {
    @Override
    public void execute() {
        GuestManagerImpl guestManager = GuestManagerImpl.getInstance();
        RoomManagerImpl roomManager = RoomManagerImpl.getInstance();
        StayInfoManagerImpl stayInfoManager = StayInfoManagerImpl.getInstance();

        Scanner scanner = new Scanner(System.in);
        System.out.println("-------All Guests-------");
        guestManager.getAllGuests().stream().forEach(System.out::println);
        System.out.println("-------All Rooms-------");
        roomManager.getAllRooms().stream().forEach(System.out::println);

        String lastName = InputReader.getStringInput(scanner,
                "Введите имя посетителя, чтобы зарегистрироваться ");
        Integer roomNumber = InputReader.getIntegerInput(scanner,
                "Введите номер комнаты: ");
        LocalDate inDate = InputReader.getLocalDateInput(scanner,
                "Введите дату заселения в номер, пример \"YYYY-MM-DD\" ");
        LocalDate outDate = InputReader.getLocalDateInput(scanner,
                "Введите дату выселения из номера, пример \"YYYY-MM-DD\" ");
        try {
            stayInfoManager.checkInGuestInRoom(guestManager.getGuestByName(lastName),
                    roomManager.getRoomByNumber(roomNumber), inDate, outDate);
        } catch (Exception e) {
            System.out.println("Не удалось зарегистрировать посетителя! " + e.getMessage());
        }
    }
}
