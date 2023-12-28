package guest;

import api.Action;
import view.HotelManagerImpl;

public class PrintGuestsImpl implements Action {

    @Override
    public void execute() {

        System.out.println("-------printAllGuest-------");
        HotelManagerImpl.getInstance().printAllGuest();
    }
}
