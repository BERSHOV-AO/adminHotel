package action.stayInfo;

import action.api.IAction;
import ru.senla.di_factory.InjectByType;
import ru.senla.stay_info.IStayInfoService;
import utils.Printer;

public class PrintStayInfoActionImpl implements IAction {
    @InjectByType
    private IStayInfoService stayInfoService;

    @Override
    public void execute() {
        Printer.printStayInfo(stayInfoService.printStayInfo());
    }
}
