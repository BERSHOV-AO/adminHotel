package action.stayInfo;

import action.api.IAction;
import ru.senla.di.InjectByType;
import ru.senla.stay_info.IStayInfoService;

public class ExportStayInfoActionImpl implements IAction {

    @InjectByType
    private IStayInfoService stayInfoService;

    @Override
    public void execute() {
        System.out.println(stayInfoService.exportStayInfoToFileCSV());
    }
}
