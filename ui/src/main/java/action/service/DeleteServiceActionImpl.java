package action.service;

import action.api.IAction;
import controllers.service.ServiceManagerImpl;
import utils.ExistsEntity;

public class DeleteServiceActionImpl implements IAction {

    @Override
    public void execute() {
        ServiceManagerImpl serviceManager = ServiceManagerImpl.getInstance();
        if (serviceManager.getAllServices().size() == 0) {
            System.out.println("Нет доступных сервисов!");
            return;
        }

        System.out.println("-----Удаление сервиса-----");
        System.out.println("-------All Services-------");
        serviceManager.getAllServices().stream().forEach(System.out::println);
        try {
            int serviceId = ExistsEntity.getExistsServiceID();
            serviceManager.deleteService(serviceManager.getServiceById(serviceId));
        } catch (Exception e) {
            System.out.println("Нет такой услуги для удаления");
        }
    }
}
