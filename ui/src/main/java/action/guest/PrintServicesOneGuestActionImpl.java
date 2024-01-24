package action.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;
import models.Service;
import utils.InputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintServicesOneGuestActionImpl implements IAction {
    @Override
    public void execute() {
        GuestManagerImpl guestManager = GuestManagerImpl.getInstance();

        Scanner scanner = new Scanner(System.in);
        System.out.println("-------All Guests-------");
        guestManager.getAllGuests().stream().forEach(System.out::println);
        List<Service> listService = new ArrayList<>();
        try {
            String lastName = InputReader.getStringInput(scanner,
                    "Введите имя посетителя, для просмотра его сервисов: ");
            listService = guestManager.getGuestServices(
                    guestManager.getGuestByName(lastName));

            StringBuilder str = new StringBuilder();
            str.append("Имя гостя: " + lastName + "\n");
            str.append("Воспользовался услугами: " + "\n");
            str.append(listService.toString());
            System.out.println(str);
        } catch (Exception e) {
            System.out.println("Не возможности распечатать сервис " + e.getMessage());
        }
    }
}
