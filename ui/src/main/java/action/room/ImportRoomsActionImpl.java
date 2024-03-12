package action.room;

import action.api.IAction;
import ru.senla.room.IRoomsService;
import ru.senla.room.RoomsServiceImpl;

public class ImportRoomsActionImpl implements IAction {

    private IRoomsService roomsService = RoomsServiceImpl.getInstance();

    @Override
    public void execute() {
        System.out.println(roomsService.importCSVFilesToRooms());
    }
}
