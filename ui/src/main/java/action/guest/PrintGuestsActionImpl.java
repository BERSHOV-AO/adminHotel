package action.guest;

import action.api.IAction;
import ru.senla.di_factory.InjectByType;
import ru.senla.guest.IGuestsService;

public class PrintGuestsActionImpl implements IAction {
    @InjectByType
    private IGuestsService guestsService;

    @Override
    public void execute() {

        System.out.println("-------All Guests-------");
        guestsService.getListGuests().stream().forEach(System.out::println);
    }
}
