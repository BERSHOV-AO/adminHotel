package room;

import api.IAction;
import utils.InputReader;
import view.HotelManagerImpl;

import java.util.Scanner;

public class ChangeRoomPriceImpl implements IAction {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        HotelManagerImpl.getInstance().printAllRooms();

        try {
            Integer roomNumber = InputReader.getIntegerInput(scanner, "Введите номер комнаты: ");
            Double priceDay = InputReader.getDoubleInput(scanner, "Введите новую стоимость номера за сутки ");

            HotelManagerImpl.getInstance().changeRoomPrice(HotelManagerImpl.getInstance().getRoomByNumber(roomNumber),
                    priceDay);
        } catch (Exception e) {
            System.out.println("Не удалось изменить цену номера " + e.getMessage());
        }
    }
}