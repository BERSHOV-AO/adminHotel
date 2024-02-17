package action.service;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.repository.service.IServicesRepository;
import ru.senla.repository.service.ServicesRepositoryImpl;
import utils.ExistsEntity;

public class DeleteServiceActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(DeleteServiceActionImpl.class);
    private IServicesRepository servicesRepository = ServicesRepositoryImpl.getInstance();

    @Override
    public void execute() {

        if (ExistsEntity.noExistServices(servicesRepository.getAllServices())) {
            return;
        }

        System.out.println("-----Удаление сервиса-----");
        System.out.println("-------All Services-------");
        servicesRepository.getAllServices().stream().forEach(System.out::println);
        try {
            int serviceId = ExistsEntity.getExistsServiceID(servicesRepository);
            servicesRepository.deleteService(servicesRepository.getServiceById(serviceId));
            logger.info(String.format("Удален сервис с id: %d", serviceId));
        } catch (Exception e) {
            System.out.println("Сервис не удален" + e.getMessage());
            logger.warn("Сервис не удален", e);
        }
    }
}
