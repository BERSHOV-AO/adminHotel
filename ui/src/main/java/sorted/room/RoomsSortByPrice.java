package sorted.room;

import api.IAction;
import view.HotelManagerImpl;

public class RoomsSortByPrice implements IAction {
    @Override
    public void execute() {
        HotelManagerImpl.getInstance().showServicesSortByPrice();
    }
}
