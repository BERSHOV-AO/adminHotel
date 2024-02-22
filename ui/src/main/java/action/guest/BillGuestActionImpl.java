package action.guest;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.guest.GuestsServiceImpl;
import ru.senla.guest.IGuestsService;
import ru.senla.room.IRoomsService;
import ru.senla.room.RoomsServiceImpl;
import ru.senla.stay_info.IStayInfoService;
import ru.senla.stay_info.StayInfoServiceImpl;
import utils.InputReader;
import utils.Printer;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class BillGuestActionImpl implements IAction {
    final static Logger logger = Logger.getLogger(BillGuestActionImpl.class);
    private static Scanner scanner = new Scanner(System.in);
    private IStayInfoService stayInfoService = StayInfoServiceImpl.getInstance();
    private IGuestsService guestsService = GuestsServiceImpl.getInstance();
    private IRoomsService roomsService = RoomsServiceImpl.getInstance();


    @Override
    public void execute() {
        try {

            Printer.printStayInfo(stayInfoService.getMapStayInfo());
            int guestId = InputReader.getIntegerInput(scanner, "Введите id посетителя: ");
            int roomId = InputReader.getIntegerInput(scanner, "Введите id комнаты: ");

            Locale ruLocale = new Locale("ru", "RU");
            NumberFormat rubFormat = NumberFormat.getCurrencyInstance(ruLocale);


//            int guestId = ExistsEntity.getExistsGuestID(guestsRepository);
//            int roomId = ExistsEntity.getExistsRoomID(roomsRepository);

            StringBuilder str = new StringBuilder();

            str.append("************--BILL--************" + "\n");
            str.append("Имя гостя: " + guestsService.getLastNameGuestById(guestId) + "\n");
            str.append("Номер комнаты: " + roomsService.getRoomNumberById(roomId)+ "\n");
            str.append("Счет за номер : ");
            str.append(rubFormat.format(stayInfoRepository.getBillForRoomGuest(guestsRepository.getGuestById(guestId),
                    roomsRepository.getRoomById(roomId))) + "\n");
            str.append("********************************" + "\n");

            if (stayInfoRepository.getListStayInfoOneGuest(guestsRepository.getGuestById(guestId)) != null) {
                str.append("Счет за сервис : ");
                str.append(rubFormat.format(stayInfoRepository.getBillServiceByGuest(
                        guestsRepository.getGuestById(guestId))) + "\n");
                str.append("********************************" + "\n");
            } else {
                str.append("Гость " + guestsRepository.getGuestById(guestId).getLastName() +
                        " сервисами не пользовался!" + "\n");
                str.append("********************************");
                logger.info(String.format("Гость с id: %d, номер с id: %d, счет за проживание равен: %.2f руб.",
                        guestId, roomId, stayInfoRepository.getBillForRoomGuest(
                                guestsRepository.getGuestById(guestId), roomsRepository.getRoomById(roomId))));
            }
            System.out.println(str);
        } catch (Exception e) {
            System.out.println("Нет такого посетителя или счета" + e.getMessage());
            logger.warn("Нет такого посетителя или счета ", e);
        }
    }
}