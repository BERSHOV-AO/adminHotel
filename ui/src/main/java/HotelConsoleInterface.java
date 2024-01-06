import api.IAction;
import guest.AddGuestImpl;
import guest.CheckInImpl;
import guest.CheckOutImpl;
import room.AddRoomImpl;

import java.util.Scanner;

public class HotelConsoleInterface {

    private Scanner scanner;
    private boolean running;

    public HotelConsoleInterface() {
        this.scanner = new Scanner(System.in);
        this.running = true;
    }

    public void start() {
        while (running) {
            displayMenu();
            int choice = getUserChoice();
            executeAction(choice);
        }
    }

    private void displayMenu() {
        System.out.println("Welcome to the Hotel Management System");
        System.out.println("1. Add a guest");
        System.out.println("2. Add a room");
        System.out.println("3. Check-in a guest");
        System.out.println("4. Check-out a guest");
        System.out.println("5. Exit");
    }

    private int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private void executeAction(int choice) {
        switch (choice) {
            case 1:
                IAction addGuestIAction = new AddGuestImpl();
                addGuestIAction.execute();
                break;
            case 2:
                IAction removeGuestIAction = new AddRoomImpl();
                removeGuestIAction.execute();
                break;
            case 3:
                IAction checkInIAction = new CheckInImpl();
                checkInIAction.execute();
                break;
            case 4:
                IAction checkOutIAction = new CheckOutImpl();
                checkOutIAction.execute();
                break;
            case 5:
                running = false;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void main(String[] args) {
        HotelConsoleInterface hotelConsoleInterface = new HotelConsoleInterface();
        hotelConsoleInterface.start();
    }

}


