package action.service;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.entities.Service;
import ru.senla.enums.ServiceType;
import ru.senla.repository.service.IServicesRepository;
import ru.senla.repository.service.ServicesRepositoryImpl;
import utils.InputReader;

import java.util.Scanner;

public class AddServiceActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(AddServiceActionImpl.class);
    private IServicesRepository servicesRepository = ServicesRepositoryImpl.getInstance();

    @Override
    public void execute() {

        System.out.println("-----Регистрация сервисов------");
        Scanner scanner = new Scanner(System.in);
        try {
            ServiceType serviceType = InputReader.getServiceTypeByInput(scanner,
                    "Введите число соответствующее сервису : 1 = BREAKFAST, 2 = LUNCH, 3 = DINNER, " +
                            "4 = LAUNDRY");
            Double servicePrice = InputReader.getDoubleInput(scanner, "Введите цену сервиса: ");
            servicesRepository.addService(new Service(serviceType, servicePrice));
            logger.info(String.format("Добавлен сервис: %s, цена: %.2f", serviceType, servicePrice));
        } catch (Exception e) {
            System.out.println("Не удалось добавить услугу. Введите действительные параметры!" + e.getMessage());
            logger.warn("Не удалось добавить услугу. Введите действительные параметры!", e);
        }
    }
}
