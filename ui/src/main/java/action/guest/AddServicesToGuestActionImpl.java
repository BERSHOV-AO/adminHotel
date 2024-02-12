package action.guest;

import action.api.IAction;
import controllers.guest.GuestManager;
import controllers.guest.GuestManagerImpl;
import controllers.service.ServiceManager;
import controllers.service.ServiceManagerImpl;
import org.apache.log4j.Logger;
import utils.ExistsEntity;

public class AddServicesToGuestActionImpl implements IAction {
    final static Logger logger = Logger.getLogger(AddServicesToGuestActionImpl.class);

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
            logger.info(String.format("Посетителю с id: %d добавлена услуга с id: %d ", guestId, serviceId));
        } catch (Exception e) {
            System.out.println("Не удалось добавить сервис посетителю " + e.getMessage());
            logger.warn("Не удалось добавить сервис посетителю ", e);
        }
    }
}