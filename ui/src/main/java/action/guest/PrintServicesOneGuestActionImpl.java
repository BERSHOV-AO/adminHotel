package action.guest;

import action.api.IAction;
import controllers.guest.GuestManager;
import controllers.guest.GuestManagerImpl;
import models.Service;
import org.apache.log4j.Logger;
import utils.ExistsEntity;

import java.util.List;

public class PrintServicesOneGuestActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(PrintServicesOneGuestActionImpl.class);

    @Override
    public void execute() {
        GuestManager guestManager = GuestManagerImpl.getInstance();

        if (ExistsEntity.noExistGuests(guestManager.getAllGuests())) {
            return;
        }
        System.out.println("-------All Guests-------");
        guestManager.getAllGuests().stream().forEach(System.out::println);
        List<Service> listService;
        try {
            int guestId = ExistsEntity.getExistsGuestID(guestManager);
            listService = guestManager.getGuestServices(
                    guestManager.getGuestById(guestId));

            StringBuilder str = new StringBuilder();
            str.append("Имя гостя: " + guestManager.getGuestById(guestId).getLastName() + "\n");
            str.append("Воспользовался услугами: " + "\n");
            str.append(listService.toString());
            System.out.println(str);
        } catch (Exception e) {
            System.out.println("Нет возможности распечатать сервис " + e.getMessage());
            logger.warn("Нет возможности распечатать сервис ", e);
        }
    }
}
