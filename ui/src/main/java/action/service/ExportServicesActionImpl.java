package action.service;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.repository.service.IServicesRepository;
import ru.senla.repository.service.ServicesRepositoryImpl;
import utils.ExistsEntity;

public class ExportServicesActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(ExportServicesActionImpl.class);

    @Override
    public void execute() {
        IServicesRepository servicesRepository = ServicesRepositoryImpl.getInstance();
        if (ExistsEntity.noExistServices(servicesRepository.getAllServices())) {
            return;
        }

        try {
            servicesRepository.exportServicesToFileCSV();
            System.out.println("Услуги успешно экспортированы!");
            logger.info("Услуги(Сервис) успешно экспортированы!");
        } catch (Exception e) {
            System.out.println("Услуги не экспортированы!" + e.getMessage());
            logger.warn("Услуги(Сервис) не экспортированы!", e);
        }
    }
}
