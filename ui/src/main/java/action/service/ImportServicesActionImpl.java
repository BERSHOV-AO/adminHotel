package action.service;

import action.api.IAction;
import controllers.service.ServiceManager;
import controllers.service.ServiceManagerImpl;
import org.apache.log4j.Logger;

public class ImportServicesActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(ImportServicesActionImpl.class);

    @Override
    public void execute() {
        ServiceManager serviceManager = ServiceManagerImpl.getInstance();

        try {
            serviceManager.importCSVFilesToServices();
            System.out.println("Услуги успешно импортированы!");
            logger.info("Услуги(Сервис) успешно импортированы!");
        } catch (Exception e) {
            System.out.println("Услуги не импортированы!" + e.getMessage());
            logger.warn("Услуги(Сервис) не импортированы!" + e.getMessage());
        }

    }
}
