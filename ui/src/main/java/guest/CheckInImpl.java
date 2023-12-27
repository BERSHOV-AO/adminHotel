package guest;

import api.Action;
import view.HotelManagerImpl;

import java.util.Scanner;

public class CheckInImpl implements Action {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        HotelManagerImpl.getInstance().printAllGuest();
        HotelManagerImpl.getInstance().printAllRooms();




    }

}
