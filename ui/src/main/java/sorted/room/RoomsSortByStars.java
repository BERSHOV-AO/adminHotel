package sorted.room;

import api.IAction;
import view.HotelManagerImpl;

public class RoomsSortByStars implements IAction {
    @Override
    public void execute() {
        HotelManagerImpl.getInstance().showSortRoomsByStars();
    }
}
