package guest;

import api.Action;
import utils.InputReader;
import view.HotelManagerImpl;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class BillGuestImpl implements Action {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        Locale ruLocale = new Locale("ru", "RU");
        NumberFormat rubFormat = NumberFormat.getCurrencyInstance(ruLocale);

        HotelManagerImpl.getInstance().showStayInfo();
        String lastName = InputReader.getStringInput(scanner,
                "Введите имя посетителя для выставления счета: ");
        StringBuilder str = new StringBuilder();
        Integer roomNumber = InputReader.getIntegerInput(scanner, "Введите номер комнаты: ");
        str.append("************--BILL--************" + "\n");
        str.append("Имя гостя: " + lastName + "\n");
        str.append("Номер комнаты: " + roomNumber + "\n");
        str.append("Счет за номер : ");
        str.append(rubFormat.format(HotelManagerImpl.getInstance().getBillForRoomAndGuest(HotelManagerImpl.getInstance()
                        .getGuestByName(lastName),
                HotelManagerImpl.getInstance().getRoomByNumber(roomNumber))) + "\n");
        str.append("Счет за сервис: ");
        str.append(rubFormat.format(HotelManagerImpl.getInstance().getBillServiceOneGuest(HotelManagerImpl.getInstance()
                .getGuestByName(lastName))) + "\n");
        str.append("********************************");

        System.out.println(str);

        try {
        } catch (Exception e) {
            System.out.println("Нет такого посетителя или счета");
        }
    }
}