package action.sorted.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;
import controllers.service.ServiceManagerImpl;
import utils.InputReader;

import java.util.Scanner;

public class GuestSortServicesByPriceActionImpl implements IAction {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------All Guests-------");
        GuestManagerImpl.getInstance().getAllGuests().stream().forEach(System.out::println);

        String lastName = InputReader.getStringInput(scanner, "Введите имя посетителя : ");

        System.out.println("У посетителя с именем " + lastName + " сортированные сервисы по цене: " + "\n");
        ServiceManagerImpl.getInstance().getListServicesSortByPriceOneGuest(GuestManagerImpl.getInstance()
                .getGuestServices(GuestManagerImpl.getInstance().getGuestByName(lastName)));
    }
}
