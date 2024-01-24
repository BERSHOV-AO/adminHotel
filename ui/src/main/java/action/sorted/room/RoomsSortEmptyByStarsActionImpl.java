package action.sorted.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;

public class RoomsSortEmptyByStarsActionImpl implements IAction {
    @Override
    public void execute() {
        RoomManagerImpl roomManager = RoomManagerImpl.getInstance();

        System.out.println("-------Sorted empty rooms by stars-------");
        roomManager.getFreeRooms(roomManager.getSortedRoomsByStars()).stream().forEach(System.out::println);
    }
}
