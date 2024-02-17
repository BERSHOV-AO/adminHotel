package action.sorted.room;

import action.api.IAction;
import ru.senla.repository.room.IRoomsRepository;
import ru.senla.repository.room.RoomsRepositoryImpl;
import utils.ExistsEntity;

public class RoomsSortByCapacityActionImpl implements IAction {
    private IRoomsRepository roomsRepository = RoomsRepositoryImpl.getInstance();

    @Override
    public void execute() {
        if (ExistsEntity.noExistRooms(roomsRepository.getAllRooms())) {
            return;
        }
        System.out.println("-------Sorted rooms by capacity-------");
        roomsRepository.getSortedRoomsByCapacity().stream().forEach(System.out::println);
    }
}
