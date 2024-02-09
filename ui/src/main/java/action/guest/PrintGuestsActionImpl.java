package action.guest;

import action.api.IAction;
import controllers.guest.GuestManager;
import controllers.guest.GuestManagerImpl;
import utils.ExistsEntity;

public class PrintGuestsActionImpl implements IAction {

    @Override
    public void execute() {
        GuestManager guestManager = GuestManagerImpl.getInstance();

        if (ExistsEntity.noExistGuests(guestManager.getAllGuests())){
            return;
        }
        System.out.println("-------All Guests-------");
        GuestManagerImpl.getInstance().getAllGuests().stream().forEach(System.out::println);
    }
}
