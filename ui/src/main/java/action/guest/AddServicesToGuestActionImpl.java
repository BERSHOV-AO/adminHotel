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
        try {
            String lastName = InputReader.getStringInput(scanner,
                    "Введите имя посетителя, чтобы ему добавить сервис ");
            ServiceType serviceType = ServiceType.integerServiceType(InputReader.getIntegerInput(scanner,
                    "Введите число соответствующее сервису : " +
                            "1 = BREAKFAST, 2 = LUNCH, 3 = DINNER, 4 = LAUNDRY"));
            System.out.println("Вы выбрали сервис: " + serviceType);
            guestManager.addServicesToGuest(guestManager.getGuestByName(lastName),
                    serviceManager.getServiceByType(serviceType));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}