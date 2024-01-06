package sorted.guest;

import api.IAction;
import view.HotelManagerImpl;

public class GuestsSortByNameImpl implements IAction {
    @Override
    public void execute() {
        System.out.println("-----Сортировка гостей по имени-----");
        HotelManagerImpl.getInstance().sortGuestsByName();
    }
}
