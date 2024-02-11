package action.sorted.guest;

import action.api.IAction;
import controllers.guest.GuestManager;
import controllers.guest.GuestManagerImpl;
import utils.ExistsEntity;

public class GuestsSortByNameActionImpl implements IAction {
    @Override
    public void execute() {
        GuestManager guestManager = GuestManagerImpl.getInstance();
        if (ExistsEntity.noExistGuests(guestManager.getAllGuests())) {
            return;
        }
        System.out.println("-----Сортировка гостей по имени-----");
        guestManager.getSortedGuestsByAlphabet().stream().forEach(System.out::println);
    }
}
