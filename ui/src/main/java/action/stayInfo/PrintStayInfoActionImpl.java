package action.stayInfo;

import action.api.IAction;
import controllers.stay_info.StayInfoManager;
import controllers.stay_info.StayInfoManagerImpl;
import utils.ExistsEntity;
import utils.Printer;

public class PrintStayInfoActionImpl implements IAction {

    @Override
    public void execute() {
        StayInfoManager stayInfoManager = StayInfoManagerImpl.getInstance();
        if (ExistsEntity.noExistStayInfo(stayInfoManager.getMapStayInfo())) {
            return;
        }
        Printer.printStayInfo(StayInfoManagerImpl.getInstance().getMapStayInfo());
    }
}
