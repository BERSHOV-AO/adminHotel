package action.service;

import action.api.IAction;
import controllers.service.ServiceManagerImpl;
import enums.ServiceType;
import utils.InputReader;
import utils.LogicDetails;

import java.util.Scanner;

public class ChangeServiceOnPriceActionImpl implements IAction {
    @Override
    public void execute() {

        System.out.println("-----Изменение цены сервиса-----");
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------All Services-------");
        ServiceManagerImpl.getInstance().getAllServices().stream().forEach(System.out::println);

        try {
            ServiceType serviceType = LogicDetails.integerServiceType(InputReader.getIntegerInput(scanner,
                    "Для изменения цены сервиса, введите число соответствующее сервису : " +
                            "1 = BREAKFAST, 2 = LUNCH, 3 = DINNER, 4 = LAUNDRY"));
            Double servicePrice = InputReader.getDoubleInput(scanner, "Введите новую цену сервиса: ");
            ServiceManagerImpl.getInstance().changeServicePrice(ServiceManagerImpl.getInstance()
                    .getServiceByType(serviceType), servicePrice);
        } catch (Exception e) {
            System.out.println("Нет такой услуги, чтобы изменить ее цену! " + e);
        }
    }
}
