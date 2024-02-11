package action.sorted.service;

import action.api.IAction;
import controllers.service.ServiceManager;
import controllers.service.ServiceManagerImpl;
import utils.ExistsEntity;

public class ServicesSortByNameActionImpl implements IAction {
    @Override
    public void execute() {
        ServiceManager serviceManager = ServiceManagerImpl.getInstance();
        if (ExistsEntity.noExistServices(serviceManager.getAllServices())) {
            return;
        }
        System.out.println("-----Сортировка сервисов по алфавиту-----");
        serviceManager.getListSortBySection().stream().forEach(System.out::println);
    }
}
