package action.stayInfo;

import action.api.IAction;
import ru.senla.di_factory.InjectByType;
import ru.senla.stay_info.IStayInfoService;
import ru.senla.stay_info.StayInfoServiceImpl;

public class ExportStayInfoActionImpl implements IAction {

    @InjectByType
    private IStayInfoService stayInfoService; // = StayInfoServiceImpl.getInstance();

    @Override
    public void execute() {
        System.out.println(stayInfoService.exportStayInfoToFileCSV());
    }
}
