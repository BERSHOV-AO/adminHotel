package action.sorted.guest;

import action.api.IAction;
import ru.senla.repository.guest.GuestsRepositoryImpl;
import ru.senla.repository.guest.IGuestsRepository;
import ru.senla.repository.service.IServicesRepository;
import ru.senla.repository.service.ServicesRepositoryImpl;
import utils.ExistsEntity;

public class GuestSortServicesByPriceActionImpl implements IAction {

    private IGuestsRepository guestsRepository = GuestsRepositoryImpl.getInstance();
    private IServicesRepository servicesRepository = ServicesRepositoryImpl.getInstance();

    @Override
    public void execute() {

        if (ExistsEntity.noExistGuests(guestsRepository.getAllGuests())) {
            return;
        }
        System.out.println("-------All Guests-------");
        guestsRepository.getAllGuests().stream().forEach(System.out::println);
        int guestId = ExistsEntity.getExistsGuestID(guestsRepository);
        System.out.println("У посетителя с именем " + guestsRepository.getGuestById(guestId).getLastName() +
                " сортированные сервисы по цене: " + "\n");
        servicesRepository.getListServicesSortByPriceOneGuest(guestsRepository
                .getGuestServices(guestsRepository.getGuestById(guestId)));
    }
}
