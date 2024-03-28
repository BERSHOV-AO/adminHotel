package action.sorted.service;

import action.api.IAction;
import ru.senla.di.InjectByType;
import ru.senla.service.IServicesService;

public class ServicesSortByNameActionImpl implements IAction {
    @InjectByType
    private IServicesService servicesService;

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
