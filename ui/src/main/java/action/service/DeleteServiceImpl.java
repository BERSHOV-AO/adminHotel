package action.service;

import action.api.IAction;
import enums.ServiceType;
import utils.InputReader;
import utils.LogicDetails;
import view.HotelManagerImpl;

import java.util.Scanner;

public class DeleteServiceImpl implements IAction {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("-----Удаление сервиса-----");
        HotelManagerImpl.getInstance().printAllService();
        try {
            ServiceType serviceType = LogicDetails.integerServiceType(InputReader.getIntegerInput(scanner,
                    "Введите число соответствующее сервису, для его удаления: " +
                            "1 = BREAKFAST, 2 = LUNCH, 3 = DINNER, 4 = LAUNDRY"));

            HotelManagerImpl.getInstance().deleteService(HotelManagerImpl.getInstance().getServiceByType(serviceType));
        } catch (Exception e) {
            System.out.println("Нет такой услуги для удаления");
        }
    }
}
