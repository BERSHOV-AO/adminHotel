package action.service;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.repository.service.IServicesRepository;
import ru.senla.repository.service.ServicesRepositoryImpl;

public class ImportServicesActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(ImportServicesActionImpl.class);
    private IServicesRepository servicesRepository = ServicesRepositoryImpl.getInstance();

    @Override
    public void execute() {

        try {
            servicesRepository.importCSVFilesToServices();
            System.out.println("Услуги успешно импортированы!");
            logger.info("Услуги(Сервис) успешно импортированы!");
        } catch (Exception e) {
            System.out.println("Услуги не импортированы!" + e.getMessage());
            logger.warn("Услуги(Сервис) не импортированы!" + e.getMessage());
        }
    }
}
