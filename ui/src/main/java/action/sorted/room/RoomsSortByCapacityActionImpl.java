package action.sorted.room;

import action.api.IAction;
import ru.senla.room.IRoomsService;
import ru.senla.room.RoomsServiceImpl;

public class RoomsSortByCapacityActionImpl implements IAction {
    private IRoomsService roomsService = RoomsServiceImpl.getInstance();

    @Override
    public void execute() {
        try {
            System.out.println("-------Sorted rooms by capacity-------");
            roomsService.getListSortedRoomsByCapacity().stream().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error sorted rooms by capacity " + e.getMessage());
        }
    }
}
