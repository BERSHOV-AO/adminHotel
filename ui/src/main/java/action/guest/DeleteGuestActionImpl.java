package action.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;
import utils.ExistsEntity;
import utils.InputReader;

import java.util.Scanner;

public class DeleteGuestActionImpl implements IAction {
    @Override
    public void execute() {
        GuestManagerImpl guestManager = GuestManagerImpl.getInstance();
        if (guestManager.getAllGuests().size() == 0) {
            System.out.println("Нет доступных гостей!");
            return;
        }

        System.out.println("-------All Guests-------");
        guestManager.getAllGuests().stream().forEach(System.out::println);
        try {
            int guestId = ExistsEntity.getExistsGuestID();
            guestManager.deleteGuest(guestManager.getGuestById(guestId));
        } catch (Exception e) {
            System.out.println("Посетитель не удален " + e.getMessage());
        }
    }
}
