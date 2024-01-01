package guest;

import api.Action;
import enums.ServiceType;
import models.Guest;
import models.Service;
import utils.InputReader;
import view.HotelManagerImpl;

import java.util.Scanner;

public class AddServicesToGuestImpl implements Action {
    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        HotelManagerImpl.getInstance().printAllGuest();
        ServiceType serviceType;

        try {
            String lastName = InputReader.getStringInput(scanner,
                    "Введите имя посетителя, чтобы ему добавить сервис ");

            String service = InputReader.getStringInput(scanner, "Введите название сервиса " +
                    "(BREAKFAST, LUNCH, DINNER или LAUNDRY): ");

            serviceType = ServiceType.valueOf(service.toUpperCase());
            System.out.println("Вы выбрали сервис: " + serviceType);

            HotelManagerImpl.getInstance().addServicesToGuest(HotelManagerImpl.getInstance().getGuestByName(lastName),
                    HotelManagerImpl.getInstance().getServiceByType(serviceType));
        } catch (Exception e) {

        }
    }
}


// try {
//
//         String lastName = InputReader.getStringInput(scanner,
//         "Введите имя посетителя, чтобы выселить ");
//         do {
//         System.out.print("Введите название сервиса (BREAKFAST, LUNCH, DINNER или LAUNDRY): ");
//         String input = scanner.nextLine();
//
//         try {
//         serviceType = ServiceType.valueOf(input.toUpperCase());
//         System.out.println("Вы выбрали сервис: " + serviceType);
//         } catch (IllegalArgumentException e) {
//         System.out.println("Некорректное название сервиса!");
//         serviceType = null; // Сбрасываем значение переменной, чтобы продолжить цикл
//         }
//         } while (serviceType == null);
//
//         Service service = HotelManagerImpl.getInstance().getServiceByType(serviceType);
//         HotelManagerImpl.getInstance().addServicesToGuest();