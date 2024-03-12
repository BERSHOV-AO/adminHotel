package action.guest;

import action.api.IAction;
import ru.senla.guest.GuestsServiceImpl;
import ru.senla.guest.IGuestsService;

public class ImportGuestsActionImpl implements IAction {
    private IGuestsService guestsService = GuestsServiceImpl.getInstance();

    @Override
    public void execute() {
        System.out.println(guestsService.importCSVFilesToGuests());
    }
}
