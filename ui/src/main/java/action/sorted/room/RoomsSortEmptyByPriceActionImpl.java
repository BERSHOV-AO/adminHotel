package action.sorted.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;

public class RoomsSortEmptyByPriceActionImpl implements IAction {
    @Override
    public void execute() {
        System.out.println("-------Sorted empty rooms by price-------");
        RoomManagerImpl.getInstance().getFreeRooms(RoomManagerImpl.getInstance().getSortedRoomsByPrice())
                .stream().forEach(System.out::println);
    }
}
