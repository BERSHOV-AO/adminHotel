package service;

import api.Action;
import view.HotelManagerImpl;

public class PrintServiceImpl implements Action {
    @Override
    public void execute() {
        System.out.println("-------printAllService-------");
        HotelManagerImpl.getInstance().printAllService();
    }
}
