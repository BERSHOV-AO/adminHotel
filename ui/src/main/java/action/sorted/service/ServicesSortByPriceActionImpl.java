package action.sorted.service;

import action.api.IAction;
import ru.senla.di_factory.InjectByType;
import ru.senla.service.IServicesService;

public class ServicesSortByPriceActionImpl implements IAction {
    @InjectByType
    private IServicesService servicesService;

    @Override
    public void execute() {

        try {
            System.out.println("-------Sorting services by price-------");
            servicesService.getListSortedServiceByPrice().stream().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error sorted services by price " + e.getMessage());
        }
    }
}
