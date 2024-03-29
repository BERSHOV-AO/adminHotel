package action.service;

import action.api.IAction;
import ru.senla.enums.ServiceType;
import ru.senla.service.IServicesService;
import ru.senla.service.ServicesServiceImpl;
import utils.InputReader;

import java.util.Scanner;

public class AddServiceActionImpl implements IAction {

    private static Scanner scanner = new Scanner(System.in);
    private IServicesService servicesService = ServicesServiceImpl.getInstance();

    @Override
    public void execute() {
        ServiceType serviceType = InputReader.getServiceTypeByInput(scanner,
                "Введите число соответствующее сервису : 1 = BREAKFAST, 2 = LUNCH, 3 = DINNER, " +
                        "4 = LAUNDRY");
        Double servicePrice = InputReader.getDoubleInput(scanner, "Введите цену сервиса: ");
        System.out.println(servicesService.addService(serviceType, servicePrice));
    }
}
