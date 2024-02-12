package action.stayInfo;

import action.api.IAction;
import action.service.ExportServicesActionImpl;
import controllers.stay_info.StayInfoManager;
import controllers.stay_info.StayInfoManagerImpl;
import org.apache.log4j.Logger;
import utils.ExistsEntity;

public class ExportStayInfoActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(ExportStayInfoActionImpl.class);

    @Override
    public void execute() {
        StayInfoManager stayInfoManager = StayInfoManagerImpl.getInstance();
        if (ExistsEntity.noExistStayInfo(stayInfoManager.getMapStayInfo())) {
            return;
        }
        try {
            stayInfoManager.exportStayInfoToFileCSV();
            System.out.println("Информация о пребывании успешно экспортированы!");
            logger.info("Информация о пребывании успешно экспортированы!");
        } catch (Exception e) {
            System.out.println("Информация о пребывании не экспортирована!" + e.getMessage());
            logger.warn("Информация о пребывании не экспортирована!", e);
        }
    }
}
