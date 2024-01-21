package action.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;

public class PrintGuestsActionImpl implements IAction {

    @Override
    public void execute() {
        System.out.println("-------All Guests-------");
        GuestManagerImpl.getInstance().getAllGuests().stream().forEach(System.out::println);
    }
}
