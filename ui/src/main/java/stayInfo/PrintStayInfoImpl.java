package stayInfo;

import api.IAction;
import view.HotelManagerImpl;

public class PrintStayInfoImpl implements IAction {

    @Override
    public void execute() {
        System.out.println("-------showStayInfo-------");
        HotelManagerImpl.getInstance().showStayInfo();
    }
}
