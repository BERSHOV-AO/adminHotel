package guest;

import api.IAction;
import view.HotelManagerImpl;

public class PrintGuestsImpl implements IAction {

    @Override
    public void execute() {

        System.out.println("-------printAllGuest-------");
        HotelManagerImpl.getInstance().printAllGuest();
    }
}
