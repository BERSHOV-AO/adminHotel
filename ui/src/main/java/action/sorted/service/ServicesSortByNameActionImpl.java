package action.sorted.service;

import action.api.IAction;
import ru.senla.repository.service.IServicesRepository;
import ru.senla.repository.service.ServicesRepositoryImpl;
import utils.ExistsEntity;

public class ServicesSortByNameActionImpl implements IAction {
    private IServicesRepository servicesRepository = ServicesRepositoryImpl.getInstance();

    @Override
    public void execute() {
        if (ExistsEntity.noExistServices(servicesRepository.getAllServices())) {
            return;
        }
        System.out.println("-----Сортировка сервисов по алфавиту-----");
        servicesRepository.getListSortBySection().stream().forEach(System.out::println);
    }
}
