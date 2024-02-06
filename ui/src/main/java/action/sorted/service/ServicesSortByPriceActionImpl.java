package action.sorted.service;

import action.api.IAction;
import controllers.service.ServiceManagerImpl;

public class ServicesSortByPriceActionImpl implements IAction {
    @Override
    public void execute() {
        ServiceManagerImpl serviceManager = ServiceManagerImpl.getInstance();
        if (serviceManager.getAllServices().size() == 0) {
            System.out.println("Нет доступных сервисов!");
            return;
        }
        System.out.println("-----Сортировка сервисов по цене-----");
        serviceManager.getListSortByPrice().stream().forEach(System.out::println);
    }
}
