package action.room;

import action.api.IAction;
import ru.senla.di.InjectByType;
import ru.senla.room.IRoomsService;

public class ImportRoomsActionImpl implements IAction {

    @InjectByType
    private IRoomsService roomsService;

    @Override
    public void execute() {
        System.out.println(roomsService.importCSVFilesToRooms());
    }
}
