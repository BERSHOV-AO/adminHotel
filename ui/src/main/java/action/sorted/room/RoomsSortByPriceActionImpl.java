package action.sorted.room;

import action.api.IAction;
import ru.senla.di_factory.InjectByType;
import ru.senla.room.IRoomsService;

public class RoomsSortByPriceActionImpl implements IAction {
    @InjectByType
    private IRoomsService roomsService;

    @Override
    public void execute() {

        try {
            System.out.println("-------Sorted rooms by price-------");
            roomsService.getListSortedRoomsByPrice().stream().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error sorted rooms by price " + e.getMessage());
        }
    }
}
