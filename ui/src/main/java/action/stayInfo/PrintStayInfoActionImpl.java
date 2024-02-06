package action.stayInfo;

import action.api.IAction;
import controllers.service.ServiceManagerImpl;
import controllers.stay_info.StayInfoManagerImpl;
import utils.Printer;

public class PrintStayInfoActionImpl implements IAction {

    @Override
    public void execute() {
        StayInfoManagerImpl stayInfoManager = StayInfoManagerImpl.getInstance();
        if (stayInfoManager.getMapStayInfo().size() == 0) {
            System.out.println("Нет доступной информации о проживании!");
            return;
        }
        Printer.printStayInfo(StayInfoManagerImpl.getInstance().getMapStayInfo());
    }
}
