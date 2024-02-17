package action.stayInfo;

import action.api.IAction;
import ru.senla.repository.stay_info.IStayInfoRepository;
import ru.senla.repository.stay_info.StayInfoRepositoryImpl;
import utils.ExistsEntity;
import utils.Printer;

public class PrintStayInfoActionImpl implements IAction {
    private IStayInfoRepository stayInfoRepository = StayInfoRepositoryImpl.getInstance();
    @Override
    public void execute() {

        if (ExistsEntity.noExistStayInfo(stayInfoRepository.getMapStayInfo())) {
            return;
        }
        Printer.printStayInfo(stayInfoRepository.getMapStayInfo());
    }
}
