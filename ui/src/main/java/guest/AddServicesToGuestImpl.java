package guest;

import api.Action;
import enums.ServiceType;
import models.Guest;
import models.Service;
import utils.InputReader;
import utils.LogicDetails;
import view.HotelManagerImpl;

import java.util.Scanner;

public class AddServicesToGuestImpl implements Action {
    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        HotelManagerImpl.getInstance().printAllGuest();
        try {
            String lastName = InputReader.getStringInput(scanner,
                    "Введите имя посетителя, чтобы ему добавить сервис ");

            ServiceType serviceType = LogicDetails.integerServiceType(InputReader.getIntegerInput(scanner,
                    "Введите число соответствующее сервису : " +
                            "1 = BREAKFAST, 2 = LUNCH, 3 = DINNER, 4 = LAUNDRY"));

            System.out.println("Вы выбрали сервис: " + serviceType);

            HotelManagerImpl.getInstance().addServicesToGuest(HotelManagerImpl.getInstance().getGuestByName(lastName),
                    HotelManagerImpl.getInstance().getServiceByType(serviceType));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}