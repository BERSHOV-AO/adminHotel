package action.sorted.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;

public class RoomsSortEmptyByCapacityActionImpl implements IAction {
    @Override
    public void execute() {

        System.out.println("-------Sorted empty rooms by capacity-------");
        RoomManagerImpl.getInstance().getFreeRooms(RoomManagerImpl.getInstance().getSortedRoomsByCapacity())
                .stream().forEach(System.out::println);
    }
}
