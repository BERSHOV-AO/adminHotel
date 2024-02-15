package action.room;

import action.api.IAction;
import ru.senla.repository.room.IRoomsRepository;
import ru.senla.repository.room.RoomsRepositoryImpl;
import utils.ExistsEntity;

public class PrintRoomsActionImpl implements IAction {
    private IRoomsRepository roomsRepository = RoomsRepositoryImpl.getInstance();

    @Override
    public void execute() {
        if (ExistsEntity.noExistRooms(roomsRepository.getAllRooms())) {
            return;
        }
        System.out.println("-------All Rooms-------");
        roomsRepository.getAllRooms().stream().forEach(System.out::println);
    }
}
