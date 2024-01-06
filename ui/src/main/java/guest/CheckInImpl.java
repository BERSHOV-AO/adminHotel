package guest;

import api.IAction;
import utils.InputReader;
import view.HotelManagerImpl;

import java.time.LocalDate;
import java.util.Scanner;

public class CheckInImpl implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        HotelManagerImpl.getInstance().printAllGuest();
        HotelManagerImpl.getInstance().printAllRooms();

        String lastName = InputReader.getStringInput(scanner,
                "Введите имя посетителя, чтобы зарегистрироваться ");

        Integer roomNumber = InputReader.getIntegerInput(scanner,
                "Введите номер комнаты: ");

        LocalDate inDate = InputReader.getLocalDateInput(scanner,
                "Введите дату заселения в номер, пример \"YYYY-MM-DD\" ");
        LocalDate outDate = InputReader.getLocalDateInput(scanner,
                "Введите дату выселения из номера, пример \"YYYY-MM-DD\" ");

        try {
            HotelManagerImpl.getInstance().checkInGuestInRoom(HotelManagerImpl.getInstance().getGuestByName(lastName),
                    HotelManagerImpl.getInstance().getRoomByNumber(roomNumber), inDate, outDate);

        } catch (Exception e) {
            System.out.println("Не удалось зарегистрировать посетителя! " + e.getMessage());
        }
    }
}
