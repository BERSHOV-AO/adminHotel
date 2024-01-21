package action.sorted.service;

import action.api.IAction;
import controllers.service.ServiceManagerImpl;

public class ServicesSortByPriceActionImpl implements IAction {
    @Override
    public void execute() {
        System.out.println("-----Сортировка сервисов по цене-----");
        ServiceManagerImpl.getInstance().getListSortByPrice().stream().forEach(System.out::println);
    }
}
