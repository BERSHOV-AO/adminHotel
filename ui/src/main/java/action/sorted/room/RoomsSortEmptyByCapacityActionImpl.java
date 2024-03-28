package action.sorted.room;

import action.api.IAction;
import ru.senla.di.InjectByType;
import ru.senla.room.IRoomsService;

public class RoomsSortEmptyByCapacityActionImpl implements IAction {
    @InjectByType
    private IRoomsService roomsService;

    @Override
    public void execute() {

        try {
            System.out.println("-------Sorted empty rooms by capacity-------");
            roomsService.getListSortedEmptyRoomsByCapacity().stream().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error sorted empty rooms by capacity " + e.getMessage());
        }
    }
}
