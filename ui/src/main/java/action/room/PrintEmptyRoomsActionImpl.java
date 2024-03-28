package action.room;

import action.api.IAction;
import ru.senla.di.InjectByType;
import ru.senla.room.IRoomsService;

public class PrintEmptyRoomsActionImpl implements IAction {
    @InjectByType
    private IRoomsService roomsService;

    @Override
    public void execute() {
        System.out.println("-------Empty Rooms-------");
        roomsService.printEmptyRooms().stream().forEach(System.out::println);
    }
}
