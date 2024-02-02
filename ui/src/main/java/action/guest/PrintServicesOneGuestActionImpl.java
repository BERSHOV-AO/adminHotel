package action.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;
import models.Service;
import utils.ExistsEntity;
import utils.InputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintServicesOneGuestActionImpl implements IAction {
    @Override
    public void execute() {
        GuestManagerImpl guestManager = GuestManagerImpl.getInstance();
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
