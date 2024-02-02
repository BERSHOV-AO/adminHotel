package action.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;
import controllers.service.ServiceManagerImpl;
import utils.ExistsEntity;

public class AddServicesToGuestActionImpl implements IAction {
    @Override
    public void execute() {
        ServiceManagerImpl serviceManager = ServiceManagerImpl.getInstance();
        if (!serviceManager.existsServices()) {
            System.out.println("Нет доступных сервисов!");
            return;
        }

        GuestManagerImpl guestManager = GuestManagerImpl.getInstance();

        System.out.println("----Список посетителей----");
        guestManager.getAllGuests().stream().forEach(System.out::println);
        System.out.println("----Список доступных сервисов----");
        serviceManager.getAllServices().stream().forEach(System.out::println);
        try {
            int guestId = ExistsEntity.getExistsGuestID();
            int serviceId = ExistsEntity.getExistsServiceID();

            guestManager.addServicesToGuest(guestManager.getGuestById(guestId),
                    serviceManager.getServiceById(serviceId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}