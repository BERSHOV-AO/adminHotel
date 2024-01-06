package service;

import api.IAction;
import enums.ServiceType;
import utils.InputReader;
import utils.LogicDetails;
import view.HotelManagerImpl;

import java.util.Scanner;

public class ChangeServiceOnPriceImpl implements IAction {
    @Override
    public void execute() {

        System.out.println("-----Изменение цены сервиса-----");
        Scanner scanner = new Scanner(System.in);
        HotelManagerImpl.getInstance().printAllService();

        try {
            ServiceType serviceType = LogicDetails.integerServiceType(InputReader.getIntegerInput(scanner,
                    "Для изменения цены сервиса, введите число соответствующее сервису : " +
                            "1 = BREAKFAST, 2 = LUNCH, 3 = DINNER, 4 = LAUNDRY"));
            Double servicePrice = InputReader.getDoubleInput(scanner, "Введите новую цену сервиса: ");
            HotelManagerImpl.getInstance().changeServiceOnPrice(HotelManagerImpl.getInstance()
                    .getServiceByType(serviceType), servicePrice);
        } catch (Exception e) {
            System.out.println("Нет такой услуги, чтобы изменить ее цену! " + e);
        }
    }
}
