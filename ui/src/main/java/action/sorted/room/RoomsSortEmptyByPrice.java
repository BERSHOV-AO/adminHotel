package action.sorted.room;

import action.api.IAction;
import view.HotelManagerImpl;

public class RoomsSortEmptyByPrice implements IAction {
    @Override
    public void execute() {
        HotelManagerImpl.getInstance().showSortEmptyRoomsByPrice();
    }
}
