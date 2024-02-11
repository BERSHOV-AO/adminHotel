package action.guest;

import action.api.IAction;
import controllers.guest.GuestManager;
import controllers.guest.GuestManagerImpl;
import controllers.room.RoomManager;
import controllers.room.RoomManagerImpl;
import controllers.stay_info.StayInfoManager;
import controllers.stay_info.StayInfoManagerImpl;
import utils.ExistsEntity;
import utils.Printer;

public class CheckOutActionImpl implements IAction {
    @Override
    public void execute() {
        StayInfoManager stayInfoManager = StayInfoManagerImpl.getInstance();
        GuestManager guestManager = GuestManagerImpl.getInstance();
        RoomManager roomManager = RoomManagerImpl.getInstance();
        if (ExistsEntity.noExistStayInfo(stayInfoManager.getMapStayInfo())) {
            return;
        }

        Printer.printStayInfo(stayInfoManager.getMapStayInfo());
        int guestId = ExistsEntity.getExistsGuestID(guestManager);
        int roomId = ExistsEntity.getExistsRoomID(roomManager);

        try {
            stayInfoManager.checkOutGuestFromRoom(guestManager.getGuestById(guestId),
                    roomManager.getRoomByNumber(roomId));
        } catch (Exception e) {
            System.out.println("Некорректный ввод данных " + e.getMessage());
        }
    }
}
