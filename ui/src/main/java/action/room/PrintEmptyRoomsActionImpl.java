package action.room;

import action.api.IAction;
import ru.senla.repository.room.IRoomsRepository;
import ru.senla.repository.room.RoomsRepositoryImpl;
import utils.ExistsEntity;

public class PrintEmptyRoomsActionImpl implements IAction {
    private IRoomsRepository roomManager = RoomsRepositoryImpl.getInstance();
    @Override
    public void execute() {

        if (ExistsEntity.noExistRooms(roomManager.getAllRooms())) {
            return;
        }
        System.out.println("-------Empty Rooms-------");
        roomManager.getEmptyRooms().stream().forEach(System.out::println);
    }
}
