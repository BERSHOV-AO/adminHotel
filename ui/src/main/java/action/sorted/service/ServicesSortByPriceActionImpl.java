package action.sorted.service;

import action.api.IAction;
import controllers.service.ServiceManager;
import controllers.service.ServiceManagerImpl;
import utils.ExistsEntity;

public class ServicesSortByPriceActionImpl implements IAction {
    @Override
    public void execute() {
        ServiceManager serviceManager = ServiceManagerImpl.getInstance();
        if (ExistsEntity.noExistServices(serviceManager.getAllServices())) {
            return;
        }
        System.out.println("-----Сортировка сервисов по цене-----");
        serviceManager.getListSortByPrice().stream().forEach(System.out::println);
    }
}
