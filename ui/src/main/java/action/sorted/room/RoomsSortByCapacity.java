package action.sorted.room;

import action.api.IAction;
import view.HotelManagerImpl;

public class RoomsSortByCapacity implements IAction {
    @Override
    public void execute() {
        HotelManagerImpl.getInstance().showSortRoomsByCapacity();
    }
}
