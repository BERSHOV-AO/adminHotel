package action.service;

import action.api.IAction;
import controllers.service.ServiceManager;
import controllers.service.ServiceManagerImpl;
import utils.ExistsEntity;

public class PrintServiceActionImpl implements IAction {
    @Override
    public void execute() {
        ServiceManager serviceManager = ServiceManagerImpl.getInstance();
        if (ExistsEntity.noExistServices(serviceManager.getAllServices())) {
            return;
        }
        System.out.println("-------All Services-------");
        serviceManager.getAllServices().stream().forEach(System.out::println);
    }
}
