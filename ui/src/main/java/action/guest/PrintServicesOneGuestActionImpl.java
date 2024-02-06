package action.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;
import models.Service;
import utils.ExistsEntity;

import java.util.List;

public class PrintServicesOneGuestActionImpl implements IAction {
    @Override
    public void execute() {
        GuestManagerImpl guestManager = GuestManagerImpl.getInstance();
        if (guestManager.getAllGuests().size() == 0) {
            System.out.println("Нет доступных гостей!");
            return;
        }
        System.out.println("-------All Guests-------");
        guestManager.getAllGuests().stream().forEach(System.out::println);
        List<Service> listService;
        try {
            int guestId = ExistsEntity.getExistsGuestID();
            listService = guestManager.getGuestServices(
                    guestManager.getGuestById(guestId));

            StringBuilder str = new StringBuilder();
            str.append("Имя гостя: " + guestManager.getGuestById(guestId).getLastName() + "\n");
            str.append("Воспользовался услугами: " + "\n");
            str.append(listService.toString());
            System.out.println(str);
        } catch (Exception e) {
            System.out.println("Не возможности распечатать сервис " + e.getMessage());
        }
    }
}
