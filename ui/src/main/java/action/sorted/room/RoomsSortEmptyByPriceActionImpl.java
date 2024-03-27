package action.sorted.room;

import action.api.IAction;
import ru.senla.di_factory.InjectByType;
import ru.senla.room.IRoomsService;
import ru.senla.room.RoomsServiceImpl;

public class RoomsSortEmptyByPriceActionImpl implements IAction {
    @InjectByType
    private IRoomsService roomsService; // = RoomsServiceImpl.getInstance();

    @Override
    public void execute() {

        try {
            System.out.println("-------Sorted empty rooms by price-------");
            roomsService.getListSortedEmptyRoomsByPrice().stream().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error sorted empty rooms by price " + e.getMessage());
        }
    }
}
