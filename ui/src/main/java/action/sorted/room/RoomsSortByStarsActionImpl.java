package action.sorted.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;

public class RoomsSortByStarsActionImpl implements IAction {
    @Override
    public void execute() {
        System.out.println("-------Sorted rooms by stars-------");
        RoomManagerImpl.getInstance().getSortedRoomsByStars().stream().forEach(System.out::println);
    }
}
