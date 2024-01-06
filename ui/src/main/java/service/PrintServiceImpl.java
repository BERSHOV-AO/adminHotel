package service;

import api.IAction;
import view.HotelManagerImpl;

public class PrintServiceImpl implements IAction {
    @Override
    public void execute() {
        System.out.println("-------printAllService-------");
        HotelManagerImpl.getInstance().printAllService();
    }
}
