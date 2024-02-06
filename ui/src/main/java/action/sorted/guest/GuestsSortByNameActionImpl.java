package action.sorted.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;

public class GuestsSortByNameActionImpl implements IAction {
    @Override
    public void execute() {
        GuestManagerImpl guestManager = GuestManagerImpl.getInstance();
        if (guestManager.getAllGuests().size() == 0) {
            System.out.println("Нет доступных гостей!");
            return;
        }
        System.out.println("-----Сортировка гостей по имени-----");
        guestManager.getSortedGuestsByAlphabet().stream().forEach(System.out::println);
    }
}
