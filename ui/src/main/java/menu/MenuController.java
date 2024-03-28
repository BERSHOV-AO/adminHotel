package menu;

import ru.senla.di.ApplicationContext;
import ru.senla.di.InjectByType;
import ru.senla.guest.IGuestsService;
import ru.senla.room.IRoomsService;
import ru.senla.service.IServicesService;
import ru.senla.stay_info.IStayInfoService;
import utils.InputReader;

import java.util.Scanner;

public class MenuController {
    ApplicationContext context;

    @InjectByType
    IRoomsService roomsService;
    @InjectByType
    IGuestsService guestsService;
    @InjectByType
    IServicesService servicesService;
    @InjectByType
    IStayInfoService stayInfoService;


    public void run() {
        Builder builder = context.getObject(Builder.class);
        builder.getContext(context);
        Navigator navigator = context.getObject(Navigator.class);

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

    public void getAppContext(ApplicationContext applicationContext) {
        this.context = applicationContext;
    }
}
