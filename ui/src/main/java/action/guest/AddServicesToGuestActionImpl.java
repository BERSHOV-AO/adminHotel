package action.guest;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.repository.guest.GuestsRepositoryImpl;
import ru.senla.repository.guest.IGuestsRepository;
import ru.senla.repository.service.IServicesRepository;
import ru.senla.repository.service.ServicesRepositoryImpl;
import utils.ExistsEntity;

public class AddServicesToGuestActionImpl implements IAction {
    final static Logger logger = Logger.getLogger(AddServicesToGuestActionImpl.class);
    private IGuestsRepository guestsRepository = GuestsRepositoryImpl.getInstance();
    private IServicesRepository servicesRepository = ServicesRepositoryImpl.getInstance();

    @Override
    public void execute() {

        if (ExistsEntity.noExistGuests(guestsRepository.getAllGuests())) {
            return;
        }
        if (ExistsEntity.noExistServices(servicesRepository.getAllServices())) {
            return;
        }

        System.out.println("----Список посетителей----");
        guestsRepository.getAllGuests().stream().forEach(System.out::println);
        System.out.println("----Список доступных сервисов----");
        servicesRepository.getAllServices().stream().forEach(System.out::println);
        try {
            int guestId = ExistsEntity.getExistsGuestID(guestsRepository);
            int serviceId = ExistsEntity.getExistsServiceID(servicesRepository);

            guestsRepository.addServicesToGuest(guestsRepository.getGuestById(guestId),
                    servicesRepository.getServiceById(serviceId));
            logger.info(String.format("Посетителю с id: %d добавлена услуга с id: %d ", guestId, serviceId));
        } catch (Exception e) {
            System.out.println("Не удалось добавить сервис посетителю " + e.getMessage());
            logger.warn("Не удалось добавить сервис посетителю ", e);
        }
    }
}