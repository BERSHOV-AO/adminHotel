package sorted.service;

import api.IAction;
import view.HotelManagerImpl;

public class ServicesSortByNameImpl implements IAction {
    @Override
    public void execute() {
        System.out.println("-----Сортировка сервисов по алфавиту-----");
        HotelManagerImpl.getInstance().showServicesSortBySection();
    }
}
