package action.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;
import controllers.room.RoomManagerImpl;
import controllers.stay_info.StayInfoManagerImpl;
import utils.ExistsEntity;
import utils.InputReader;
import utils.Printer;

import java.util.Scanner;

public class CheckOutActionImpl implements IAction {
    @Override
    public void execute() {
        StayInfoManagerImpl stayInfoManager = StayInfoManagerImpl.getInstance();
        GuestManagerImpl guestManager = GuestManagerImpl.getInstance();
        RoomManagerImpl roomManager = RoomManagerImpl.getInstance();

        Printer.printStayInfo(stayInfoManager.getMapStayInfo());
        int guestId = ExistsEntity.getExistsGuestID();
        int roomId = ExistsEntity.getExistsRoomID();

        try {
            stayInfoManager.checkOutGuestFromRoom(guestManager.getGuestById(guestId),
                    roomManager.getRoomByNumber(roomId));
        } catch (Exception e) {
            System.out.println("Некорректный ввод данных " + e.getMessage());
        }
    }
}
