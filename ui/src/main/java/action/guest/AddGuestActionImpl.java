package action.guest;

import action.api.IAction;
import controllers.guest.GuestManagerImpl;
import models.Guest;
import utils.InputReader;

import java.util.Scanner;

public class AddGuestActionImpl implements IAction {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        try {
            String lastName = InputReader.getStringInput(scanner, "Введите имя посетителя, для добавления..");
            GuestManagerImpl.getInstance().addOnGuest(new Guest(lastName));

        } catch (Exception e) {
            System.out.println("Не удалось добавить посетителя. Введите допустимые параметры!" + e.getMessage());
        }
    }
}
