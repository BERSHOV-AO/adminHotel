package action.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;
import controllers.room.RoomManagerImpl;
import controllers.stay_info.StayInfoManagerImpl;
import utils.InputReader;
import utils.Printer;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class BillGuestActionImpl implements IAction {
    @Override
    public void execute() {
        try {
            StayInfoManagerImpl stayInfoManager = StayInfoManagerImpl.getInstance();
            GuestManagerImpl guestManager = GuestManagerImpl.getInstance();

            Scanner scanner = new Scanner(System.in);
            Locale ruLocale = new Locale("ru", "RU");
            NumberFormat rubFormat = NumberFormat.getCurrencyInstance(ruLocale);

            Printer.printStayInfo(stayInfoManager.getMapStayInfo());
            String lastName = InputReader.getStringInput(scanner,
                    "Введите имя посетителя для выставления счета: ");
            StringBuilder str = new StringBuilder();
            Integer roomNumber = InputReader.getIntegerInput(scanner, "Введите номер комнаты: ");
            str.append("************--BILL--************" + "\n");
            str.append("Имя гостя: " + lastName + "\n");
            str.append("Номер комнаты: " + roomNumber + "\n");
            str.append("Счет за номер : ");
            str.append(rubFormat.format(stayInfoManager.getBillForRoomAndGuest(guestManager.getGuestByName(lastName),
                    RoomManagerImpl.getInstance().getRoomByNumber(roomNumber))) + "\n");
            str.append("Счет за сервис: ");
            str.append(rubFormat.format(stayInfoManager.getBillServiceOneGuest(guestManager.getGuestByName(lastName)))
                    + "\n");
            str.append("********************************");
            System.out.println(str);

        } catch (Exception e) {
            System.out.println("Нет такого посетителя или счета");
        }
    }
}