package action.sorted.service;

import action.api.IAction;
import view.HotelManagerImpl;

public class ServicesSortByPriceImpl implements IAction {
    @Override
    public void execute() {
        System.out.println("-----Сортировка сервисов по цене-----");
        HotelManagerImpl.getInstance().showServicesSortByPrice();
    }
}
