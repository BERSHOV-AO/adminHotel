package action.room;

import action.api.IAction;
import view.HotelManagerImpl;

public class PrintRoomsImpl implements IAction {

    @Override
    public void execute() {
        System.out.println("-------printAllRooms-------");
        HotelManagerImpl.getInstance().printAllRooms();
    }
}
