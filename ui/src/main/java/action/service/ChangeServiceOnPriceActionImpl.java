package action.service;

import action.api.IAction;
import controllers.service.ServiceManager;
import controllers.service.ServiceManagerImpl;
import org.apache.log4j.Logger;
import utils.ExistsEntity;
import utils.InputReader;

import java.util.Scanner;

public class ChangeServiceOnPriceActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(ChangeServiceOnPriceActionImpl.class);

    @Override
    public void execute() {
        ServiceManager serviceManager = ServiceManagerImpl.getInstance();
        if (ExistsEntity.noExistServices(serviceManager.getAllServices())) {
            return;
        }

        System.out.println("-----Изменение цены сервиса-----");
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------All Services-------");
        serviceManager.getAllServices().stream().forEach(System.out::println);
        try {
            int serviceId = ExistsEntity.getExistsServiceID(serviceManager);
            Double servicePrice = InputReader.getDoubleInput(scanner, "Введите новую цену сервиса: ");
            serviceManager.changeServicePrice(serviceManager.getServiceById(serviceId), servicePrice);
            logger.info(String.format("Стоимость сервиса с id %d, изменена на: %.2f", serviceId, servicePrice));
        } catch (Exception e) {
            System.out.println("Нет такой услуги, чтобы изменить ее цену! " + e.getMessage());
            logger.warn("Нет такой услуги, чтобы изменить ее цену! ", e);
        }
    }
}
