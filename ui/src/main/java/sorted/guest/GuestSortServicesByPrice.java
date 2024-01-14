package sorted.guest;

import api.IAction;
import utils.InputReader;
import view.HotelManagerImpl;

import java.util.Scanner;

public class GuestSortServicesByPrice implements IAction {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        HotelManagerImpl.getInstance().printAllGuest();

        String lastName = InputReader.getStringInput(scanner, "Введите имя посетителя : ");

        System.out.println("У посетителя с именем " + lastName + " сортированные сервисы по цене: " + "\n");
        HotelManagerImpl.getInstance().showServiceSortByPriceOneGuest(HotelManagerImpl.getInstance()
                .getGuestServices(HotelManagerImpl.getInstance().getGuestByName(lastName)));
    }
}
