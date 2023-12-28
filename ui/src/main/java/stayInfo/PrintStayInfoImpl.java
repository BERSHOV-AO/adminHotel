package stayInfo;

import api.Action;
import view.HotelManagerImpl;

public class PrintStayInfoImpl implements Action {

    @Override
    public void execute() {
        System.out.println("-------showStayInfo-------");
        HotelManagerImpl.getInstance().showStayInfo();
    }
}
