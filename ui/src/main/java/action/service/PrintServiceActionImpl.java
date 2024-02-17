package action.service;

import action.api.IAction;
import ru.senla.repository.service.IServicesRepository;
import ru.senla.repository.service.ServicesRepositoryImpl;
import utils.ExistsEntity;

public class PrintServiceActionImpl implements IAction {

    private IServicesRepository servicesRepository = ServicesRepositoryImpl.getInstance();
    @Override
    public void execute() {

        if (ExistsEntity.noExistServices(servicesRepository.getAllServices())) {
            return;
        }
        System.out.println("-------All Services-------");
        servicesRepository.getAllServices().stream().forEach(System.out::println);
    }
}
