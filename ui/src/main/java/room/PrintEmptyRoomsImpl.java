package room;

import api.IAction;
import view.HotelManagerImpl;

public class PrintEmptyRoomsImpl implements IAction {
    @Override
    public void execute() {
        HotelManagerImpl.getInstance().showEmptyRooms();
    }
}
