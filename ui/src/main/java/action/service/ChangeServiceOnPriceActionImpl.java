package action.service;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.repository.service.IServicesRepository;
import ru.senla.repository.service.ServicesRepositoryImpl;
import utils.ExistsEntity;
import utils.InputReader;

import java.util.Scanner;

public class ChangeServiceOnPriceActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(ChangeServiceOnPriceActionImpl.class);
    private IServicesRepository servicesRepository = ServicesRepositoryImpl.getInstance();

    @Override
    public void execute() {

        if (ExistsEntity.noExistServices(servicesRepository.getAllServices())) {
            return;
        }

        System.out.println("-----Изменение цены сервиса-----");
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------All Services-------");
        servicesRepository.getAllServices().stream().forEach(System.out::println);
        try {
            int serviceId = ExistsEntity.getExistsServiceID(servicesRepository);
            Double servicePrice = InputReader.getDoubleInput(scanner, "Введите новую цену сервиса: ");
            servicesRepository.changeServicePrice(servicesRepository.getServiceById(serviceId), servicePrice);
            logger.info(String.format("Стоимость сервиса с id %d, изменена на: %.2f", serviceId, servicePrice));
        } catch (Exception e) {
            System.out.println("Нет такой услуги, чтобы изменить ее цену! " + e.getMessage());
            logger.warn("Нет такой услуги, чтобы изменить ее цену! ", e);
        }
    }
}
