package action.guest;

import action.api.IAction;
import controllers.guest.GuestManager;
import controllers.guest.GuestManagerImpl;
import models.Guest;
import org.apache.log4j.Logger;
import utils.InputReader;

import java.util.Scanner;

public class AddGuestActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(AddGuestActionImpl.class);

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        try {
            GuestManager guestManager = GuestManagerImpl.getInstance();
            String lastName = InputReader.getStringInput(scanner, "Введите имя посетителя, для добавления..");
            guestManager.addOnGuest(new Guest(lastName));
            logger.info(String.format("Добавлен посетитель: %s", lastName));
        } catch (Exception e) {
            System.out.println("Не удалось добавить посетителя. Введите допустимые параметры!" + e.getMessage());
            logger.warn("Не удалось добавить посетителя. Введите допустимые параметры!", e);
        }
    }
}
