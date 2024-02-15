package action.room;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.entities.Room;
import ru.senla.enums.RoomStatus;
import ru.senla.repository.room.IRoomsRepository;
import ru.senla.repository.room.RoomsRepositoryImpl;
import utils.InputReader;

import java.util.Scanner;

public class AddRoomActionImpl implements IAction {
    final static Logger logger = Logger.getLogger(AddRoomActionImpl.class);
    private IRoomsRepository roomsRepository = RoomsRepositoryImpl.getInstance();

    @Override
    public void execute() {

        try {
            Scanner scanner = new Scanner(System.in);

            int roomNumber;
            boolean roomExists;
            do {
                roomNumber = InputReader.getIntegerInput(scanner, "Введите номер комнаты: ");
                roomExists = roomsRepository.checkRoomNumberExists(roomNumber);
                if (roomExists) {
                    System.out.println("Комната с номером: " + roomNumber +
                            " уже существует! Введите другой номер комнаты");
                }
            } while (roomExists);

            Integer capacity = InputReader.getIntegerInput(scanner, "Введите вместимость комнаты: ");
            Double priceDay = InputReader.getDoubleInput(scanner, "Введите стоимость номера за сутки ");
            Integer stars = InputReader.getIntegerInput(scanner,
                    "Введите количество звезд номера от 1 до 5 звезд");
            RoomStatus status = InputReader.getRoomStatusByInput(scanner,
                    "Введите цифру статуса номера: " +
                            "1 = EMPTY, 2 = OCCUPIED, 3 = UNDER_REPAIR, 4 = SERVICE");
            roomsRepository.addRoom(new Room(roomNumber, stars, priceDay, capacity, status));
            logger.info(String.format("Добавлена комната, номер: %d, количество звезд: %d, цена: %.2f," +
                    " вместимость: %d, статус: " + status, roomNumber, stars, priceDay, capacity));
        } catch (Exception e) {
            System.out.println("Не удалось добавить комнату! Введите правильные параметры " + e.getMessage());
            logger.warn("Не удалось добавить комнату! Введите правильные параметры ", e);
        }
    }
}
