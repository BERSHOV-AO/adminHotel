package action.service;

import action.api.IAction;
import controllers.service.ServiceManagerImpl;

public class ImportServicesActionImpl implements IAction {
    @Override
    public void execute() {
        ServiceManagerImpl serviceManager = ServiceManagerImpl.getInstance();
        serviceManager.importCSVFilesToServices();
    }
}
