package action.sorted.guest;

import action.api.IAction;
import ru.senla.repository.guest.GuestsRepositoryImpl;
import ru.senla.repository.guest.IGuestsRepository;
import utils.ExistsEntity;

public class GuestsSortByNameActionImpl implements IAction {
    private IGuestsRepository guestsRepository = GuestsRepositoryImpl.getInstance();
    @Override
    public void execute() {

        if (ExistsEntity.noExistGuests(guestsRepository.getAllGuests())) {
            return;
        }
        System.out.println("-----Сортировка гостей по имени-----");
        guestsRepository.getSortedGuestsByAlphabet().stream().forEach(System.out::println);
    }
}
