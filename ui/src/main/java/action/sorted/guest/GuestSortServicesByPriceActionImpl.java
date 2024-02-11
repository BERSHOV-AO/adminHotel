package action.sorted.guest;

import action.api.IAction;
import controllers.guest.GuestManager;
import controllers.guest.GuestManagerImpl;
import controllers.service.ServiceManager;
import controllers.service.ServiceManagerImpl;
import utils.ExistsEntity;

public class GuestSortServicesByPriceActionImpl implements IAction {

    @Override
    public void execute() {
        GuestManager guestManager = GuestManagerImpl.getInstance();
        ServiceManager serviceManager = ServiceManagerImpl.getInstance();

        if (ExistsEntity.noExistGuests(guestManager.getAllGuests())) {
            return;
        }
        System.out.println("-------All Guests-------");
        guestManager.getAllGuests().stream().forEach(System.out::println);
        int guestId = ExistsEntity.getExistsGuestID(guestManager);
        System.out.println("У посетителя с именем " + guestManager.getGuestById(guestId).getLastName() +
                " сортированные сервисы по цене: " + "\n");
        serviceManager.getListServicesSortByPriceOneGuest(guestManager
                .getGuestServices(guestManager.getGuestById(guestId)));
    }
}
