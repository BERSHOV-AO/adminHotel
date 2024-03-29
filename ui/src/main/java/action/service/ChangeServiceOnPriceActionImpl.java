package action.service;

import action.api.IAction;
import ru.senla.service.IServicesService;
import ru.senla.service.ServicesServiceImpl;
import utils.InputReader;

import java.util.Scanner;

public class ChangeServiceOnPriceActionImpl implements IAction {

    private static Scanner scanner = new Scanner(System.in);
    private IServicesService servicesService = ServicesServiceImpl.getInstance();

    @Override
    public void execute() {
        System.out.println("-------All Services-------");
        servicesService.getListServices().stream().forEach(System.out::println);
        int serviceId = InputReader.getIntegerInput(scanner, "Введите id сервиса ");
        Double servicePriceNew = InputReader.getDoubleInput(scanner, "Введите новую цену сервиса: ");
        System.out.println(servicesService.changeServicePrice(serviceId, servicePriceNew));
    }
}
