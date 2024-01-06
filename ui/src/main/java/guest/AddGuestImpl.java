package guest;

import api.IAction;
import models.Guest;
import utils.InputReader;
import view.HotelManagerImpl;

import java.util.Scanner;

public class AddGuestImpl implements IAction {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        try {
            String lastName = InputReader.getStringInput(scanner, "Введите имя посетителя, для добавления..");
            HotelManagerImpl.getInstance().addGuest(new Guest(lastName));

        } catch (Exception e) {
            System.out.println("Не удалось добавить посетителя. Введите допустимые параметры!" + e.getMessage());
        }
    }
}
