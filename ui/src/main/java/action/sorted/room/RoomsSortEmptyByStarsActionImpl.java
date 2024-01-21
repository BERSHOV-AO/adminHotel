package action.sorted.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;
//import view.HotelManagerImpl;

public class RoomsSortEmptyByStarsActionImpl implements IAction {
    @Override
    public void execute() {
        System.out.println("-------Sorted empty rooms by stars-------");
        RoomManagerImpl.getInstance().getFreeRooms(RoomManagerImpl.getInstance().getSortedRoomsByStars())
                .stream().forEach(System.out::println);
    }
}
