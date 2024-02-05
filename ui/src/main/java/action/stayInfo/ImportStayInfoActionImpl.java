package action.stayInfo;

import action.api.IAction;
import controllers.stay_info.StayInfoManagerImpl;

public class ImportStayInfoActionImpl implements IAction {
    @Override
    public void execute() {
        StayInfoManagerImpl stayInfoManager = StayInfoManagerImpl.getInstance();
        stayInfoManager.importCSVFilesToStayInfo();
    }
}
