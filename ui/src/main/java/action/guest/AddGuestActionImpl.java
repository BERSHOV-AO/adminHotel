package action.guest;

import action.api.IAction;
import ru.senla.di.InjectByType;
import ru.senla.guest.IGuestsService;
import utils.InputReader;

import java.util.Scanner;

public class AddGuestActionImpl implements IAction {
    private static Scanner scanner = new Scanner(System.in);
    @InjectByType
    private IGuestsService guestsService;

    @Override
    public void execute() {
        try {
            String lastName = InputReader.getStringInput(scanner, "Введите имя посетителя, для добавления..");
            System.out.println(guestsService.addGuest(lastName));
        } catch (Exception e) {
            System.out.println("Не удалось добавить посетителя. Введите допустимые параметры!" + e.getMessage());
        }
    }
}
