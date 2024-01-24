package action.service;

import action.api.IAction;
import controllers.service.ServiceManagerImpl;
import enums.ServiceType;
import models.Service;
import utils.InputReader;

import java.util.Scanner;

public class AddServiceActionImpl implements IAction {
    @Override
    public void execute() {
        ServiceManagerImpl serviceManager = ServiceManagerImpl.getInstance();

        System.out.println("-----Регистрация сервисов------");
        Scanner scanner = new Scanner(System.in);
        try {
            ServiceType serviceType = ServiceType.integerServiceType(InputReader.getIntegerInput(scanner,
                    "Введите число соответствующее сервису : " +
                            "1 = BREAKFAST, 2 = LUNCH, 3 = DINNER, 4 = LAUNDRY"));
            Double servicePrice = InputReader.getDoubleInput(scanner, "Введите цену сервиса: ");
            serviceManager.addService(new Service(serviceType, servicePrice));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
