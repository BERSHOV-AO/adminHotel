package action.service;

import action.api.IAction;
import controllers.service.ServiceManager;
import controllers.service.ServiceManagerImpl;
import utils.ExistsEntity;

public class ExportServicesActionImpl implements IAction {
    @Override
    public void execute() {
        ServiceManager serviceManager = ServiceManagerImpl.getInstance();
        if (ExistsEntity.noExistServices(serviceManager.getAllServices())) {
            return;
        }
        serviceManager.exportServicesToFileCSV();
    }
}
