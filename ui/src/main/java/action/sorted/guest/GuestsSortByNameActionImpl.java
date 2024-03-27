package action.sorted.guest;

import action.api.IAction;
import ru.senla.di_factory.InjectByType;
import ru.senla.guest.GuestsServiceImpl;
import ru.senla.guest.IGuestsService;

public class GuestsSortByNameActionImpl implements IAction {
    @InjectByType
    private IGuestsService guestsService; // = GuestsServiceImpl.getInstance();

    @Override
    public void execute() {
        System.out.println("-----Сортировка гостей по имени-----");
        guestsService.getListSortedGuestsByAlphabet().stream().forEach(System.out::println);
    }
}
