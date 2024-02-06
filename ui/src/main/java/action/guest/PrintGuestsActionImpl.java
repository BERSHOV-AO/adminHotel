package action.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;

public class PrintGuestsActionImpl implements IAction {

    @Override
    public void execute() {
        GuestManagerImpl guestManager = GuestManagerImpl.getInstance();
        if (guestManager.getAllGuests().size() == 0) {
            System.out.println("Нет доступных гостей!");
            return;
        }
        System.out.println("-------All Guests-------");
        GuestManagerImpl.getInstance().getAllGuests().stream().forEach(System.out::println);
    }
}
