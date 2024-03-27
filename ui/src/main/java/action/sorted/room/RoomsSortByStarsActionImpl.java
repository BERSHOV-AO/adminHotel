package action.sorted.room;

import action.api.IAction;
import ru.senla.di_factory.InjectByType;
import ru.senla.room.IRoomsService;
import ru.senla.room.RoomsServiceImpl;

public class RoomsSortByStarsActionImpl implements IAction {
    @InjectByType
    private IRoomsService roomsService; // = RoomsServiceImpl.getInstance();

    @Override
    public void execute() {

        try {
            System.out.println("-------Sorted rooms by stars-------");
            roomsService.getListSortedRoomsByStars().stream().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error sorted rooms by stars " + e.getMessage());
        }
    }
}
