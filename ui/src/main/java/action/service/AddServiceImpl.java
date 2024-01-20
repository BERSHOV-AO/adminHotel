package action.service;

import action.api.IAction;
import enums.ServiceType;
import models.Service;
import utils.InputReader;
import utils.LogicDetails;
import view.HotelManagerImpl;

import java.util.Scanner;

public class AddServiceImpl implements IAction {
    @Override
    public void execute() {

        System.out.println("-----Регистрация сервисов------");

        Scanner scanner = new Scanner(System.in);
        try {
            ServiceType serviceType = LogicDetails.integerServiceType(InputReader.getIntegerInput(scanner,
                    "Введите число соответствующее сервису : " +
                            "1 = BREAKFAST, 2 = LUNCH, 3 = DINNER, 4 = LAUNDRY"));

            Double servicePrice = InputReader.getDoubleInput(scanner, "Введите цену сервиса: ");
            HotelManagerImpl.getInstance().createService(new Service(serviceType, servicePrice));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
