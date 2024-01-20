package action.stayInfo;

import action.api.IAction;
import view.HotelManagerImpl;

public class PrintStayInfoImpl implements IAction {

    @Override
    public void execute() {
        System.out.println("-------showStayInfo-------");
        HotelManagerImpl.getInstance().showStayInfo();
    }
}
