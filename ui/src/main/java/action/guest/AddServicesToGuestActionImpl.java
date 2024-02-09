package action.guest;

import action.api.IAction;
import controllers.guest.GuestManager;
import controllers.guest.GuestManagerImpl;
import controllers.service.ServiceManager;
import controllers.service.ServiceManagerImpl;
import utils.ExistsEntity;

public class AddServicesToGuestActionImpl implements IAction {
    @Override
    public void execute() {

        GuestManager guestManager = GuestManagerImpl.getInstance();
        if (ExistsEntity.noExistGuests(guestManager.getAllGuests())) {
            return;
        }
        ServiceManager serviceManager = ServiceManagerImpl.getInstance();
        if (ExistsEntity.noExistServices(serviceManager.getAllServices())) {
            return;
        }

        System.out.println("----Список посетителей----");
        guestManager.getAllGuests().stream().forEach(System.out::println);
        System.out.println("----Список доступных сервисов----");
        serviceManager.getAllServices().stream().forEach(System.out::println);
        try {
            int guestId = ExistsEntity.getExistsGuestID(guestManager);
            int serviceId = ExistsEntity.getExistsServiceID(serviceManager);

            guestManager.addServicesToGuest(guestManager.getGuestById(guestId),
                    serviceManager.getServiceById(serviceId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}