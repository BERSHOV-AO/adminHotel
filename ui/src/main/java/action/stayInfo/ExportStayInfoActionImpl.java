package action.stayInfo;

import action.api.IAction;
import controllers.stay_info.StayInfoManagerImpl;

public class ExportStayInfoActionImpl implements IAction {
    @Override
    public void execute() {
        StayInfoManagerImpl stayInfoManager = StayInfoManagerImpl.getInstance();
        if (stayInfoManager.getMapStayInfo().size() == 0) {
            System.out.println("Нет доступной информации о проживании!");
            return;
        }
        stayInfoManager.exportStayInfoToFileCSV();
    }
}
