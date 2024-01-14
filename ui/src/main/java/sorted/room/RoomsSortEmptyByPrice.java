package sorted.room;

import api.IAction;
import view.HotelManagerImpl;

public class RoomsSortEmptyByPrice implements IAction {
    @Override
    public void execute() {
        HotelManagerImpl.getInstance().showSortEmptyRoomsByPrice();
    }
}
