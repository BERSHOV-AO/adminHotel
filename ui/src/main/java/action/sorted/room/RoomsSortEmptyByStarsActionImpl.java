package action.sorted.room;

import action.api.IAction;
import ru.senla.repository.room.IRoomsRepository;
import ru.senla.repository.room.RoomsRepositoryImpl;
import utils.ExistsEntity;

public class RoomsSortEmptyByStarsActionImpl implements IAction {
    private IRoomsRepository roomsRepository = RoomsRepositoryImpl.getInstance();

    @Override
    public void execute() {
        if (ExistsEntity.noExistRooms(roomsRepository.getAllRooms())) {
            return;
        }
        System.out.println("-------Sorted empty rooms by stars-------");
        roomsRepository.getFreeRooms(roomsRepository.getSortedRoomsByStars()).stream().forEach(System.out::println);
    }
}
