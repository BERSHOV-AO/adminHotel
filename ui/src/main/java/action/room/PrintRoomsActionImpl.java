package action.room;

import action.api.IAction;

import ru.senla.room.IRoomsService;
import ru.senla.room.RoomsServiceImpl;

public class PrintRoomsActionImpl implements IAction {
    private IRoomsService roomsService = RoomsServiceImpl.getInstance();

    @Override
    public void execute() {
        System.out.println("-------All Rooms-------");
        roomsService.getListRooms().stream().forEach(System.out::println);
    }
}
