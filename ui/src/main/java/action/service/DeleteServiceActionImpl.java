package action.service;

import action.api.IAction;
import controllers.service.ServiceManagerImpl;
import enums.ServiceType;
import utils.InputReader;
import utils.LogicDetails;

import java.util.Scanner;

public class DeleteServiceActionImpl implements IAction {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("-----Удаление сервиса-----");
        System.out.println("-------All Services-------");
        ServiceManagerImpl.getInstance().getAllServices().stream().forEach(System.out::println);
        try {
            ServiceType serviceType = LogicDetails.integerServiceType(InputReader.getIntegerInput(scanner,
                    "Введите число соответствующее сервису, для его удаления: " +
                            "1 = BREAKFAST, 2 = LUNCH, 3 = DINNER, 4 = LAUNDRY"));

            ServiceManagerImpl.getInstance().deleteService(ServiceManagerImpl.getInstance().getServiceByType(serviceType));
        } catch (Exception e) {
            System.out.println("Нет такой услуги для удаления");
        }
    }
}
