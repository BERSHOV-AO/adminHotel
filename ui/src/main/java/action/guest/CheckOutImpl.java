package action.guest;

import action.api.IAction;
import utils.InputReader;
import view.HotelManagerImpl;

import java.util.Scanner;

public class CheckOutImpl implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        HotelManagerImpl.getInstance().showStayInfo();

        String lastName = InputReader.getStringInput(scanner,
                "Введите имя посетителя, чтобы выселить ");

        Integer roomNumber = InputReader.getIntegerInput(scanner,
                "Введите номер комнаты: ");

        try {
            HotelManagerImpl.getInstance().checkOutGuestFromRoom(HotelManagerImpl.getInstance().getGuestByName(lastName),
                    HotelManagerImpl.getInstance().getRoomByNumber(roomNumber));
        } catch (Exception e) {
            System.out.println("Некорректный ввод данных " + e.getMessage());
        }
    }
}
