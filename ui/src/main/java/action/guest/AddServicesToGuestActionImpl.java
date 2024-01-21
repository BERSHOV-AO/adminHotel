package action.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;
import controllers.service.ServiceManagerImpl;
import enums.ServiceType;
import utils.InputReader;
import utils.LogicDetails;

import java.util.Scanner;

public class AddServicesToGuestActionImpl implements IAction {
    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("----Список посетителей----");
        GuestManagerImpl.getInstance().getAllGuests().stream().forEach(System.out::println);
        try {
            String lastName = InputReader.getStringInput(scanner,
                    "Введите имя посетителя, чтобы ему добавить сервис ");

            ServiceType serviceType = LogicDetails.integerServiceType(InputReader.getIntegerInput(scanner,
                    "Введите число соответствующее сервису : " +
                            "1 = BREAKFAST, 2 = LUNCH, 3 = DINNER, 4 = LAUNDRY"));

            System.out.println("Вы выбрали сервис: " + serviceType);

            GuestManagerImpl.getInstance().addServicesToGuest(GuestManagerImpl.getInstance().getGuestByName(lastName),
                    ServiceManagerImpl.getInstance().getServiceByType(serviceType));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}