package action.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;
import utils.InputReader;

import java.util.Scanner;

public class DeleteGuestActionImpl implements IAction {
    @Override
    public void execute() {
        GuestManagerImpl guestManager = GuestManagerImpl.getInstance();

        Scanner scanner = new Scanner(System.in);
        System.out.println("-------All Guests-------");
        guestManager.getAllGuests().stream().forEach(System.out::println);
        try {
            String lastName = InputReader.getStringInput(scanner,
                    "Введите имя посетителя, для удаления: ");
            guestManager.deleteGuest(guestManager.getGuestByName(lastName));
        } catch (Exception e) {
            System.out.println("Посетитель не удален " + e.getMessage());
        }
    }
}
