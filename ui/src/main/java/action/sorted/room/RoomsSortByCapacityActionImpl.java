package action.sorted.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;

public class RoomsSortByCapacityActionImpl implements IAction {
    @Override
    public void execute() {
        System.out.println("-------Sorted rooms by capacity-------");
        RoomManagerImpl.getInstance().getSortedRoomsByCapacity().stream().forEach(System.out::println);
    }
}
