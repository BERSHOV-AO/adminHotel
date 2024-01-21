package action.sorted.service;

import action.api.IAction;
import controllers.service.ServiceManagerImpl;

public class ServicesSortByNameActionImpl implements IAction {
    @Override
    public void execute() {
        System.out.println("-----Сортировка сервисов по алфавиту-----");
        ServiceManagerImpl.getInstance().getListSortBySection().stream().forEach(System.out::println);
    }
}
