package action.sorted.service;

import action.api.IAction;
import ru.senla.service.IServicesService;
import ru.senla.service.ServicesServiceImpl;

public class ServicesSortByNameActionImpl implements IAction {
    private IServicesService servicesService = ServicesServiceImpl.getInstance();

    @Override
    public void execute() {

        try {
            System.out.println("-------Sorting services alphabetically-------");
            servicesService.getListSortedServiceByAlphabet().stream().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error sorting services alphabetically " + e.getMessage());
        }
    }
}
