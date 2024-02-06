package action.service;

import action.api.IAction;
import controllers.service.ServiceManagerImpl;

public class ExportServicesActionImpl implements IAction {
    @Override
    public void execute() {
        ServiceManagerImpl serviceManager = ServiceManagerImpl.getInstance();
        if (serviceManager.getAllServices().size() == 0) {
            System.out.println("Нет доступных сервисов!");
            return;
        }
        serviceManager.exportServicesToFileCSV();
    }
}
