package action.stayInfo;

import action.api.IAction;
import controllers.stay_info.StayInfoManagerImpl;
import utils.Printer;

public class PrintStayInfoActionImpl implements IAction {

    @Override
    public void execute() {
        Printer.printStayInfo(StayInfoManagerImpl.getInstance().getMapStayInfo());
    }
}
