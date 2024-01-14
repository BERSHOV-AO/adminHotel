package sorted.room;

import api.IAction;
import view.HotelManagerImpl;

public class RoomsSortByCapacity implements IAction {
    @Override
    public void execute() {
        HotelManagerImpl.getInstance().showSortRoomsByCapacity();
    }
}
