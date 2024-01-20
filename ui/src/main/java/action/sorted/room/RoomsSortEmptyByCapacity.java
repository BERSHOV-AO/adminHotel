package action.sorted.room;

import action.api.IAction;
import view.HotelManagerImpl;

public class RoomsSortEmptyByCapacity implements IAction {
    @Override
    public void execute() {
        HotelManagerImpl.getInstance().showSortEmptyRoomsByCapacity();
    }
}
