package action.sorted.room;

import action.api.IAction;
import ru.senla.repository.room.IRoomsRepository;
import ru.senla.repository.room.RoomsRepositoryImpl;
import utils.ExistsEntity;

public class RoomsSortByStarsActionImpl implements IAction {

    private IRoomsRepository roomsRepository = RoomsRepositoryImpl.getInstance();

    @Override
    public void execute() {
        if (ExistsEntity.noExistRooms(roomsRepository.getAllRooms())) {
            return;
        }
        System.out.println("-------Sorted rooms by stars-------");
        roomsRepository.getSortedRoomsByStars().stream().forEach(System.out::println);
    }
}
