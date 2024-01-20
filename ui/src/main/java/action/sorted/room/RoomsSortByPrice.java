package action.sorted.room;

import action.api.IAction;
import view.HotelManagerImpl;

public class RoomsSortByPrice implements IAction {
    @Override
    public void execute() {
        HotelManagerImpl.getInstance().showServicesSortByPrice();
    }
}
