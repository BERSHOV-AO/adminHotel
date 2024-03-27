package action.guest;

import action.api.IAction;

import ru.senla.di_factory.InjectByType;
import ru.senla.guest.GuestsServiceImpl;
import ru.senla.guest.IGuestsService;

public class ExportGuestsActionImpl implements IAction {
    @InjectByType
    private IGuestsService guestsService; // = GuestsServiceImpl.getInstance();

    @Override
    public void execute() {
        try {
            System.out.println(guestsService.exportGuestsToFileCSV());
        } catch (Exception e) {
            System.out.println("Посетители не экспортированы!" + e.getMessage());
        }
    }
}
