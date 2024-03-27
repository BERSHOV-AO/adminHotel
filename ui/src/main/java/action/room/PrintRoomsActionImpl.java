package action.room;

import action.api.IAction;

import ru.senla.di_factory.InjectByType;
import ru.senla.room.IRoomsService;

public class PrintRoomsActionImpl implements IAction {
    @InjectByType
    private IRoomsService roomsService;

    @Override
    public void execute() {
        System.out.println("-------All Rooms-------");
        roomsService.getListRooms().stream().forEach(System.out::println);
    }
}
