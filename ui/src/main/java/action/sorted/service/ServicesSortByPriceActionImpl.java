package action.sorted.service;

import action.api.IAction;
import ru.senla.service.IServicesService;
import ru.senla.service.ServicesServiceImpl;

public class ServicesSortByPriceActionImpl implements IAction {
    private IServicesService servicesService = ServicesServiceImpl.getInstance();

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
