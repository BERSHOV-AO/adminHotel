package menu;

import ru.senla.di_factory.InjectByType;
import ru.senla.guest.GuestsServiceImpl;
import ru.senla.guest.IGuestsService;
import ru.senla.room.IRoomsService;
import ru.senla.room.RoomsServiceImpl;
import ru.senla.service.IServicesService;
import ru.senla.service.ServicesServiceImpl;
import ru.senla.stay_info.IStayInfoService;
import ru.senla.stay_info.StayInfoServiceImpl;
import utils.InputReader;

import java.util.Scanner;

public class MenuController {

    private Builder builder = new Builder();
    private Navigator navigator = new Navigator();

    @InjectByType
    IRoomsService roomsService;
    @InjectByType
    IGuestsService guestsService;
    @InjectByType
    IServicesService servicesService;
    @InjectByType
    IStayInfoService stayInfoService;



    public void run() {

        Scanner scanner = new Scanner(System.in);

        navigator.setCurrentMenu(builder.getMenu());
        navigator.printMenu();

        while (true) {

            Integer choice = InputReader.getIntegerInput(scanner) - 1;

            if (choice >= navigator.getCurrentMenu().getMenuItems().size()) {
                System.out.println("Incorrect choice. Try again");
                continue;
            } else {
                navigator.navigate(choice);
            }

            if (navigator.getCurrentMenu().getMenuItems().get(choice).getNextMenu() == null) {
                roomsService.serializerRooms();
                guestsService.serializerGuests();
                servicesService.serializerServices();
                stayInfoService.serializerStayInfo();
                break;
            }
            navigator.setCurrentMenu(navigator.getCurrentMenu().getMenuItems().get(choice).getNextMenu());
            navigator.printMenu();
        }
        scanner.close();
        System.out.println("Goodbye!");
    }
}
