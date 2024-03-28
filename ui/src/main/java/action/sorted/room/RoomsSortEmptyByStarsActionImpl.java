package action.sorted.room;

import action.api.IAction;
import ru.senla.di.InjectByType;
import ru.senla.room.IRoomsService;

public class RoomsSortEmptyByStarsActionImpl implements IAction {
    @InjectByType
    private IRoomsService roomsService;

    @Override
    public void execute() {
        try {
            System.out.println("-------Sorted empty rooms by stars-------");
            roomsService.getListSortedEmptyRoomsByStars().stream().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error sorted empty rooms by stars " + e.getMessage());
        }
    }
}
