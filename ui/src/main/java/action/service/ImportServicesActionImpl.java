package action.service;

import action.api.IAction;
import ru.senla.service.IServicesService;
import ru.senla.service.ServicesServiceImpl;

public class ImportServicesActionImpl implements IAction {

    private IServicesService servicesService = ServicesServiceImpl.getInstance();

    @Override
    public void execute() {
        System.out.println(servicesService.importCSVFilesToServices());
    }
}
