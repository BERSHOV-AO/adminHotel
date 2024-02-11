package action.guest;

import action.api.IAction;
import controllers.guest.GuestManager;
import controllers.guest.GuestManagerImpl;
import controllers.room.RoomManager;
import controllers.room.RoomManagerImpl;
import controllers.stay_info.StayInfoManager;
import controllers.stay_info.StayInfoManagerImpl;
import org.apache.log4j.Logger;
import utils.ExistsEntity;
import utils.Printer;

import java.text.NumberFormat;
import java.util.Locale;

public class BillGuestActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(BillGuestActionImpl.class);
    @Override
    public void execute() {
        try {
            StayInfoManager stayInfoManager = StayInfoManagerImpl.getInstance();
            GuestManager guestManager = GuestManagerImpl.getInstance();
            RoomManager roomManager = RoomManagerImpl.getInstance();

            if (ExistsEntity.noExistStayInfo(stayInfoManager.getMapStayInfo())) {
                return;
            }
            Locale ruLocale = new Locale("ru", "RU");
            NumberFormat rubFormat = NumberFormat.getCurrencyInstance(ruLocale);

            Printer.printStayInfo(stayInfoManager.getMapStayInfo());
            int guestId = ExistsEntity.getExistsGuestID(guestManager);
            int roomId = ExistsEntity.getExistsRoomID(roomManager);

            StringBuilder str = new StringBuilder();

            str.append("************--BILL--************" + "\n");
            str.append("Имя гостя: " + guestManager.getGuestById(guestId).getLastName() + "\n");
            str.append("Номер комнаты: " + roomManager.getRoomById(roomId).getRoomNumber() + "\n");
            str.append("Счет за номер : ");
            str.append(rubFormat.format(stayInfoManager.getBillForRoomGuest(guestManager.getGuestById(guestId),
                    roomManager.getRoomById(roomId))) + "\n");
            str.append("********************************" + "\n");

            if (stayInfoManager.getListStayInfoOneGuest(guestManager.getGuestById(guestId)) != null) {
                str.append("Счет за сервис : ");
                str.append(rubFormat.format(stayInfoManager.getBillServiceByGuest(
                        guestManager.getGuestById(guestId))) + "\n");
                str.append("********************************" + "\n");
            } else {
                str.append("Гость " + guestManager.getGuestById(guestId).getLastName() +
                        " сервисами не пользовался!" + "\n");
                str.append("********************************");
            }
            System.out.println(str);
        } catch (Exception e) {
            System.out.println("Нет такого посетителя или счета" + e.getMessage());
            logger.error("Нет такого посетителя или счета ", e);
        }
    }
}