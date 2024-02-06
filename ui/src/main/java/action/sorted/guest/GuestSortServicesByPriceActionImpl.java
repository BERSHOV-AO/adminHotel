package action.sorted.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;
import controllers.service.ServiceManagerImpl;
import utils.ExistsEntity;

public class GuestSortServicesByPriceActionImpl implements IAction {

    @Override
    public void execute() {
        GuestManagerImpl guestManager = GuestManagerImpl.getInstance();
        ServiceManagerImpl serviceManager = ServiceManagerImpl.getInstance();

        if (guestManager.getAllGuests().size() == 0) {
            System.out.println("Нет доступных гостей!");
            return;
        }
        System.out.println("-------All Guests-------");
        guestManager.getAllGuests().stream().forEach(System.out::println);
        int guestId = ExistsEntity.getExistsGuestID();
        System.out.println("У посетителя с именем " + guestManager.getGuestById(guestId).getLastName() +
                " сортированные сервисы по цене: " + "\n");
        serviceManager.getListServicesSortByPriceOneGuest(guestManager
                .getGuestServices(guestManager.getGuestById(guestId)));
    }
}
