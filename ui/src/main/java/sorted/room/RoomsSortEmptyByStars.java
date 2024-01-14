package sorted.room;

import api.IAction;
import view.HotelManagerImpl;

public class RoomsSortEmptyByStars implements IAction {
    @Override
    public void execute() {
        HotelManagerImpl.getInstance().showSortEmptyRoomsByStars();
    }
}
