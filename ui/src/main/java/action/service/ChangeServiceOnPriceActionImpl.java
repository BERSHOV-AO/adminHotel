package action.service;

import action.api.IAction;
import controllers.service.ServiceManagerImpl;
import enums.ServiceType;
import utils.ExistsEntity;
import utils.InputReader;

import java.util.Scanner;

public class ChangeServiceOnPriceActionImpl implements IAction {
    @Override
    public void execute() {
        ServiceManagerImpl serviceManager = ServiceManagerImpl.getInstance();

        System.out.println("-----Изменение цены сервиса-----");
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------All Services-------");
        serviceManager.getAllServices().stream().forEach(System.out::println);
        try {
           int serviceId = ExistsEntity.getExistsServiceID();
            Double servicePrice = InputReader.getDoubleInput(scanner, "Введите новую цену сервиса: ");
            serviceManager.changeServicePrice(serviceManager.getServiceById(serviceId), servicePrice);
        } catch (Exception e) {
            System.out.println("Нет такой услуги, чтобы изменить ее цену! " + e);
        }
    }
}
