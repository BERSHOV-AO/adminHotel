package action.service;

import action.api.IAction;
import controllers.service.ServiceManagerImpl;
import enums.ServiceType;
import utils.InputReader;

import java.util.Scanner;

public class DeleteServiceActionImpl implements IAction {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        ServiceManagerImpl serviceManager = ServiceManagerImpl.getInstance();

        System.out.println("-----Удаление сервиса-----");
        System.out.println("-------All Services-------");
        serviceManager.getAllServices().stream().forEach(System.out::println);
        try {
            ServiceType serviceType = InputReader.getServiceTypeByInput(scanner,
                    "Введите число соответствующее сервису : 1 = BREAKFAST, 2 = LUNCH, 3 = DINNER, " +
                            "4 = LAUNDRY");
            serviceManager.deleteService(serviceManager.getServiceByType(serviceType));
        } catch (Exception e) {
            System.out.println("Нет такой услуги для удаления");
        }
    }
}
