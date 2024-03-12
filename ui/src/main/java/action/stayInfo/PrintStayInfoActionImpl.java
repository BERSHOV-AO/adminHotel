package action.stayInfo;

import action.api.IAction;
import ru.senla.stay_info.IStayInfoService;
import ru.senla.stay_info.StayInfoServiceImpl;
import utils.Printer;

public class PrintStayInfoActionImpl implements IAction {
    private IStayInfoService stayInfoService = StayInfoServiceImpl.getInstance();

    @Override
    public void execute() {
        Printer.printStayInfo(stayInfoService.printStayInfo());
    }
}
