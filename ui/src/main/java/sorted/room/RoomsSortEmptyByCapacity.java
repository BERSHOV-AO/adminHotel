package sorted.room;

import api.IAction;
import view.HotelManagerImpl;

public class RoomsSortEmptyByCapacity implements IAction {
    @Override
    public void execute() {
        HotelManagerImpl.getInstance().showSortEmptyRoomsByCapacity();
    }
}
