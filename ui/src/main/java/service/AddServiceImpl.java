package service;

import api.Action;
import enums.ServiceType;
import models.Service;
import utils.InputReader;
import view.HotelManagerImpl;

import java.util.Scanner;

public class AddServiceImpl implements Action {
    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        ServiceType serviceType;

        do {
            System.out.print("Введите название сервиса (BREAKFAST, LUNCH, DINNER или LAUNDRY): ");
            String input = scanner.nextLine();

            try {
                serviceType = ServiceType.valueOf(input.toUpperCase());
                System.out.println("Вы выбрали сервис: " + serviceType);
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректное название сервиса!");
                serviceType = null; // Сбрасываем значение переменной, чтобы продолжить цикл
            }
        } while (serviceType == null);

        Double servicePrice = InputReader.getDoubleInput(scanner, "Введите цену сервиса: ");
        HotelManagerImpl.getInstance().createService(new Service(serviceType, servicePrice));
    }
}
