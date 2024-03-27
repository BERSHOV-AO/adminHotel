package action.service;

import action.api.IAction;
import ru.senla.di_factory.InjectByType;
import ru.senla.service.IServicesService;
import ru.senla.service.ServicesServiceImpl;

public class PrintServiceActionImpl implements IAction {

    @InjectByType
    private IServicesService servicesService; // = ServicesServiceImpl.getInstance();

    @Override
    public void execute() {
        System.out.println("-------All Services-------");
        servicesService.printServices().stream().forEach(System.out::println);
    }
}
