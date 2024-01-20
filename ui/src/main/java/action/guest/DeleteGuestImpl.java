package action.guest;

import action.api.IAction;
import utils.InputReader;
import view.HotelManagerImpl;

import java.util.Scanner;

public class DeleteGuestImpl implements IAction {
    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        HotelManagerImpl.getInstance().printAllGuest();

        try {
            String lastName = InputReader.getStringInput(scanner,
                    "Введите имя посетителя, для удаления: ");
            HotelManagerImpl.getInstance().deleteGuest(HotelManagerImpl.getInstance().getGuestByName(lastName));
        } catch (Exception e) {
            System.out.println("Посетитель не удален " + e.getMessage());
        }
    }
}
