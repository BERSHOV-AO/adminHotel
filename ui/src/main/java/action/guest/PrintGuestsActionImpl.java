package action.guest;

import action.api.IAction;
import ru.senla.repository.guest.GuestsRepositoryImpl;
import ru.senla.repository.guest.IGuestsRepository;
import utils.ExistsEntity;

public class PrintGuestsActionImpl implements IAction {
    IGuestsRepository guestsRepository = GuestsRepositoryImpl.getInstance();

    @Override
    public void execute() {

        if (ExistsEntity.noExistGuests(guestsRepository.getAllGuests())) {
            return;
        }
        System.out.println("-------All Guests-------");
        guestsRepository.getAllGuests().stream().forEach(System.out::println);
    }
}
