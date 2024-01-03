package guest;

import api.Action;
import models.Service;
import utils.InputReader;
import view.HotelManagerImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintServicesOneGuestImpl implements Action {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        HotelManagerImpl.getInstance().printAllGuest();
        List<Service> listService = new ArrayList<>();

        try {
            String lastName = InputReader.getStringInput(scanner,
                    "Введите имя посетителя, для просмотра его сервисов: ");
            listService = HotelManagerImpl.getInstance().getGuestServices(
                    HotelManagerImpl.getInstance().getGuestByName(lastName));

            StringBuilder str = new StringBuilder();
            str.append("Guest ");
            str.append(lastName);
            str.append(" has used services:");
            str.append(listService.toString());
            System.out.println(str);
        } catch (Exception e) {
            System.out.println("Не возможности распечатать сервис " + e.getMessage());
        }
    }
}
