package action.sorted.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;
import controllers.service.ServiceManagerImpl;
import utils.InputReader;

import java.util.Scanner;

public class GuestSortServicesByPriceActionImpl implements IAction {

    @Override
    public void execute() {
        GuestManagerImpl guestManager = GuestManagerImpl.getInstance();
        ServiceManagerImpl serviceManager = ServiceManagerImpl.getInstance();

        Scanner scanner = new Scanner(System.in);
        System.out.println("-------All Guests-------");
        guestManager.getAllGuests().stream().forEach(System.out::println);
        String lastName = InputReader.getStringInput(scanner, "Введите имя посетителя : ");
        System.out.println("У посетителя с именем " + lastName + " сортированные сервисы по цене: " + "\n");
        serviceManager.getListServicesSortByPriceOneGuest(guestManager
                .getGuestServices(guestManager.getGuestByName(lastName)));
    }
}
