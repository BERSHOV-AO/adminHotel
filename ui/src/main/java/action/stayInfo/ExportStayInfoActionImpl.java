package action.stayInfo;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.repository.stay_info.IStayInfoRepository;
import ru.senla.repository.stay_info.StayInfoRepositoryImpl;
import utils.ExistsEntity;

public class ExportStayInfoActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(ExportStayInfoActionImpl.class);
    private IStayInfoRepository stayInfoRepository = StayInfoRepositoryImpl.getInstance();

    @Override
    public void execute() {

        if (ExistsEntity.noExistStayInfo(stayInfoRepository.getMapStayInfo())) {
            return;
        }
        try {
            stayInfoRepository.exportStayInfoToFileCSV();
            System.out.println("Информация о пребывании успешно экспортированы!");
            logger.info("Информация о пребывании успешно экспортированы!");
        } catch (Exception e) {
            System.out.println("Информация о пребывании не экспортирована!" + e.getMessage());
            logger.warn("Информация о пребывании не экспортирована!", e);
        }
    }
}
