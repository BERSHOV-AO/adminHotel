package action.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;
import controllers.service.ServiceManagerImpl;
import enums.ServiceType;
import utils.InputReader;

import java.util.Scanner;

public class AddServicesToGuestActionImpl implements IAction {
    @Override
    public void execute() {
        GuestManagerImpl guestManager = GuestManagerImpl.getInstance();
        ServiceManagerImpl serviceManager = ServiceManagerImpl.getInstance();

        Scanner scanner = new Scanner(System.in);
        System.out.println("----Список посетителей----");
        guestManager.getAllGuests().stream().forEach(System.out::println);
        System.out.println("----Список доступных сервисов----");
        serviceManager.getAllServices().stream().forEach(System.out::println);
        try {
            Integer idGuest = InputReader.getIntegerInput(scanner,
                    "Введите id посетителя, чтобы ему добавить сервис ");
            Integer idService = InputReader.getIntegerInput(scanner,
                    "Введите id сервиса");
            guestManager.addServicesToGuest(guestManager.getGuestById(idGuest),
                    serviceManager.getServiceById(idService));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}