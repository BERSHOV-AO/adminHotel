package action.stayInfo;

import action.api.IAction;
import ru.senla.stay_info.IStayInfoService;
import ru.senla.stay_info.StayInfoServiceImpl;

public class ExportStayInfoActionImpl implements IAction {

    private IStayInfoService stayInfoService = StayInfoServiceImpl.getInstance();

    @Override
    public void execute() {
        System.out.println(stayInfoService.exportStayInfoToFileCSV());
    }
}
