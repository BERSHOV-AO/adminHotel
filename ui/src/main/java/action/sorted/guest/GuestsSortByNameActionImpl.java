package action.sorted.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;

public class GuestsSortByNameActionImpl implements IAction {
    @Override
    public void execute() {
        System.out.println("-----Сортировка гостей по имени-----");
        GuestManagerImpl.getInstance().getSortedGuestsByAlphabet().stream().forEach(System.out::println);
    }
}
