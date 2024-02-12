package action.service;

import action.api.IAction;
import controllers.service.ServiceManager;
import controllers.service.ServiceManagerImpl;
import org.apache.log4j.Logger;
import utils.ExistsEntity;

public class DeleteServiceActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(DeleteServiceActionImpl.class);

    @Override
    public void execute() {
        ServiceManager serviceManager = ServiceManagerImpl.getInstance();
        if (ExistsEntity.noExistServices(serviceManager.getAllServices())) {
            return;
        }

        System.out.println("-----Удаление сервиса-----");
        System.out.println("-------All Services-------");
        serviceManager.getAllServices().stream().forEach(System.out::println);
        try {
            int serviceId = ExistsEntity.getExistsServiceID(serviceManager);
            serviceManager.deleteService(serviceManager.getServiceById(serviceId));
            logger.info(String.format("Удален сервис с id: %d", serviceId));
        } catch (Exception e) {
            System.out.println("Сервис не удален" + e.getMessage());
            logger.warn("Сервис не удален", e);
        }
    }
}
