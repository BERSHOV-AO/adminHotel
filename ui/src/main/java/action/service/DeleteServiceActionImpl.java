package action.service;

import action.api.IAction;
import controllers.service.ServiceManager;
import controllers.service.ServiceManagerImpl;
import utils.ExistsEntity;

public class DeleteServiceActionImpl implements IAction {

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
        } catch (Exception e) {
            System.out.println("Нет такой услуги для удаления");
        }
    }
}
