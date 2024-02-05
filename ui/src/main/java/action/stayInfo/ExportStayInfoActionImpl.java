package action.stayInfo;

import action.api.IAction;
import controllers.stay_info.StayInfoManagerImpl;

public class ExportStayInfoActionImpl implements IAction {
    @Override
    public void execute() {
        StayInfoManagerImpl stayInfoManager = StayInfoManagerImpl.getInstance();
        stayInfoManager.exportStayInfoToFileCSV();
    }
}
