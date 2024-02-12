package action.service;

import action.api.IAction;
import controllers.service.ServiceManager;
import controllers.service.ServiceManagerImpl;
import org.apache.log4j.Logger;
import utils.ExistsEntity;

public class ExportServicesActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(ExportServicesActionImpl.class);

    @Override
    public void execute() {
        ServiceManager serviceManager = ServiceManagerImpl.getInstance();
        if (ExistsEntity.noExistServices(serviceManager.getAllServices())) {
            return;
        }

        try {
            serviceManager.exportServicesToFileCSV();
            System.out.println("Услуги успешно экспортированы!");
            logger.info("Услуги(Сервис) успешно экспортированы!");
        } catch (Exception e) {
            System.out.println("Услуги не экспортированы!" + e.getMessage());
            logger.warn("Услуги(Сервис) не экспортированы!", e);
        }
    }
}
