package action.guest;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.entities.Guest;
import ru.senla.repository.guest.GuestsRepositoryImpl;
import ru.senla.repository.guest.IGuestsRepository;
import utils.InputReader;

import java.util.Scanner;

public class AddGuestActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(AddGuestActionImpl.class);
    private IGuestsRepository guestsRepository = GuestsRepositoryImpl.getInstance();

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        try {
            String lastName = InputReader.getStringInput(scanner, "Введите имя посетителя, для добавления..");
            guestsRepository.addOnGuest(new Guest(lastName));
            logger.info(String.format("Добавлен посетитель: %s", lastName));
        } catch (Exception e) {
            System.out.println("Не удалось добавить посетителя. Введите допустимые параметры!" + e.getMessage());
            logger.warn("Не удалось добавить посетителя. Введите допустимые параметры!", e);
        }
    }
}
