package action.sorted.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;

public class RoomsSortByPriceActionImpl implements IAction {
    @Override
    public void execute() {
        System.out.println("-------Sorted rooms by price-------");
        RoomManagerImpl.getInstance().getSortedRoomsByPrice().stream().forEach(System.out::println);
    }
}
