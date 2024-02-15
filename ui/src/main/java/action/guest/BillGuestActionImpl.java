package action.guest;

import action.api.IAction;
import org.apache.log4j.Logger;
import ru.senla.repository.guest.GuestsRepositoryImpl;
import ru.senla.repository.guest.IGuestsRepository;
import ru.senla.repository.room.IRoomsRepository;
import ru.senla.repository.room.RoomsRepositoryImpl;
import ru.senla.repository.service.IServicesRepository;
import ru.senla.repository.service.ServicesRepositoryImpl;
import ru.senla.repository.stay_info.IStayInfoRepository;
import ru.senla.repository.stay_info.StayInfoRepositoryImpl;
import utils.ExistsEntity;
import utils.Printer;

import java.text.NumberFormat;
import java.util.Locale;

public class BillGuestActionImpl implements IAction {

    final static Logger logger = Logger.getLogger(BillGuestActionImpl.class);
    private IStayInfoRepository stayInfoRepository = StayInfoRepositoryImpl.getInstance();
    private IGuestsRepository guestsRepository = GuestsRepositoryImpl.getInstance();
    private IRoomsRepository roomsRepository = RoomsRepositoryImpl.getInstance();

    @Override
    public void execute() {
        try {
            if (ExistsEntity.noExistStayInfo(stayInfoRepository.getMapStayInfo())) {
                return;
            }

            Locale ruLocale = new Locale("ru", "RU");
            NumberFormat rubFormat = NumberFormat.getCurrencyInstance(ruLocale);

            Printer.printStayInfo(stayInfoRepository.getMapStayInfo());
            int guestId = ExistsEntity.getExistsGuestID(guestsRepository);
            int roomId = ExistsEntity.getExistsRoomID(roomsRepository);

            StringBuilder str = new StringBuilder();

            str.append("************--BILL--************" + "\n");
            str.append("Имя гостя: " + guestsRepository.getGuestById(guestId).getLastName() + "\n");
            str.append("Номер комнаты: " + roomsRepository.getRoomById(roomId).getRoomNumber() + "\n");
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