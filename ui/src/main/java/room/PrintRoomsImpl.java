package room;

import api.Action;
import view.HotelManagerImpl;

public class PrintRoomsImpl implements Action {

    @Override
    public void execute() {
        System.out.println("-------printAllRooms-------");
        HotelManagerImpl.getInstance().printAllRooms();
    }
}
