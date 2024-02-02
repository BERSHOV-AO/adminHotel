package action.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;
import controllers.room.RoomManagerImpl;
import controllers.stay_info.StayInfoManagerImpl;
import utils.ExistsEntity;
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
            RoomManagerImpl roomManager = RoomManagerImpl.getInstance();

            Locale ruLocale = new Locale("ru", "RU");
            NumberFormat rubFormat = NumberFormat.getCurrencyInstance(ruLocale);

            Printer.printStayInfo(stayInfoManager.getMapStayInfo());
            int guestId = ExistsEntity.getExistsGuestID();
            int roomId = ExistsEntity.getExistsRoomID();

            StringBuilder str = new StringBuilder();

            str.append("************--BILL--************" + "\n");
            str.append("Имя гостя: " + guestManager.getGuestById(guestId).getLastName() + "\n");
            str.append("Номер комнаты: " + roomManager.getRoomById(roomId).getRoomNumber() + "\n");
            str.append("Счет за номер : ");
            str.append(rubFormat.format(stayInfoManager.getBillForRoomGuest(guestManager.getGuestById(guestId),
                    roomManager.getRoomById(roomId))) + "\n");
            str.append("********************************");
            System.out.println("size: " + stayInfoManager.getListStayInfoOneGuest(guestManager.getGuestById(guestId)).size());
//            if(stayInfoManager.getListStayInfoOneGuest(guestManager.getGuestById(guestId)).size() != 0){
//               str.append("Счет за сервис : ");
//                str.append(rubFormat.format(stayInfoManager.getBillServiceByGuest(
//                        guestManager.getGuestById(guestId))));
//                str.append("********************************");
//           }
            System.out.println(str);
        } catch (Exception e) {
            System.out.println("Нет такого посетителя или счета");
        }
    }
}