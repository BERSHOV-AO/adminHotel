package action.service;

import action.api.IAction;
import ru.senla.di_factory.InjectByType;
import ru.senla.service.IServicesService;
import utils.InputReader;

import java.util.Scanner;

public class ChangeServiceOnPriceActionImpl implements IAction {

    private static Scanner scanner = new Scanner(System.in);
    @InjectByType
    private IServicesService servicesService;

    @Override
    public void execute() {
        System.out.println("-------All Services-------");
        servicesService.getListServices().stream().forEach(System.out::println);
        int serviceId = InputReader.getIntegerInput(scanner, "Введите id сервиса ");
        Double servicePriceNew = InputReader.getDoubleInput(scanner, "Введите новую цену сервиса: ");
        System.out.println(servicesService.changeServicePrice(serviceId, servicePriceNew));
    }
}
