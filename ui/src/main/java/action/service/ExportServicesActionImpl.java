package action.service;

import action.api.IAction;
import controllers.service.ServiceManagerImpl;

public class ExportServicesActionImpl implements IAction {
    @Override
    public void execute() {
        ServiceManagerImpl serviceManager = ServiceManagerImpl.getInstance();
        serviceManager.exportServicesToFileCSV();
    }
}
