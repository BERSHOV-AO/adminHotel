package ru.senla.guest;

import ru.senla.entities.Guest;
import ru.senla.entities.Service;
import ru.senla.enums.response.GuestResponse;
import ru.senla.enums.response.RoomResponse;
import ru.senla.properties.ConfigReader;
import ru.senla.repository.guest.GuestsRepositoryImpl;
import ru.senla.repository.guest.IGuestsRepository;
import ru.senla.repository.room.IRoomsRepository;
import ru.senla.repository.room.RoomsRepositoryImpl;
import ru.senla.repository.service.IServicesRepository;
import ru.senla.repository.service.ServicesRepositoryImpl;

import org.apache.log4j.Logger;
import ru.senla.repository.stay_info.IStayInfoRepository;
import ru.senla.repository.stay_info.StayInfoRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

public class GuestsServiceImpl implements IGuestsService {

    final static Logger logger = Logger.getLogger(GuestsServiceImpl.class);
    private IGuestsRepository guestsRepository = GuestsRepositoryImpl.getInstance();
    private IServicesRepository servicesRepository = ServicesRepositoryImpl.getInstance();
    private IStayInfoRepository stayInfoRepository = StayInfoRepositoryImpl.getInstance();
    private IRoomsRepository roomsRepository = RoomsRepositoryImpl.getInstance();

    private static GuestsServiceImpl instance;

    private GuestsServiceImpl() {
    }

    public static GuestsServiceImpl getInstance() {
        if (instance == null) {
            instance = new GuestsServiceImpl();
        }
        return instance;
    }

    @Override
    public String addServicesToGuest(int guestId, int serviceId) {

        if (guestsRepository.checkGuestIDExists(guestId) && servicesRepository.checkServiceIDExists(serviceId)) {
            guestsRepository.addServicesToGuest(guestsRepository.getGuestById(guestId),
                    servicesRepository.getServiceById(serviceId));
            logger.info(String.format("Посетителю с id: %d добавлена услуга с id: %d ", guestId, serviceId));
            return GuestResponse.SERVICE_ADDED.getMessage();
        } else {
            return GuestResponse.SERVICE_NOT_ADDED.getMessage();
        }
    }

    @Override
    public String addGuest(String lastName) {
        guestsRepository.addOnGuest(new Guest(lastName));
        logger.info(String.format("Гость с именем %s добавлен", lastName));
        return GuestResponse.GUEST_ADDED.getMessage();
    }

    @Override
    public Guest getGuestByID(int guestId) {
        return guestsRepository.getGuestById(guestId);
    }

    @Override
    public String billGuest() {
        return null;
    }


    @Override
    public List<Guest> getListGuests() {
        return guestsRepository.getAllGuests();
    }

    @Override
    public String checkInGuest(int guestId, int roomId, LocalDate inDate, LocalDate outDate) {

        if (!roomsRepository.checkRoomIDExists(roomId)) {
            return RoomResponse.ROOM_WITH_ID_DOES_NOT_EXIST.getMessage();
        }
        if (!guestsRepository.checkGuestIDExists(guestId)) {
            return GuestResponse.GUEST_WITH_ID_DOES_NOT_EXIST.getMessage();
        }

        stayInfoRepository.checkInGuestInRoom(guestsRepository.getGuestById(guestId),
                roomsRepository.getRoomById(roomId), inDate, outDate);
        stayInfoRepository.addRoomHistoryByCount(roomsRepository.getRoomById(roomId),
                guestsRepository.getGuestById(guestId), inDate, outDate,
                ConfigReader.getReader().getHistoryRecordsCount());

        logger.info(String.format("Заселение гостя с id: %d, в номер с id: %d, дата заселения %s, дата выселения %s"
                , guestId, roomId, inDate.toString(), outDate.toString()));

        return GuestResponse.GUEST_CHECKED_INTO_THE_ROOM.getMessage();
    }

    @Override
    public String checkOutGuest(int guestId, int roomId) {

        if (!roomsRepository.checkRoomIDExists(roomId)) {
            return RoomResponse.ROOM_WITH_ID_DOES_NOT_EXIST.getMessage();
        }
        if (!guestsRepository.checkGuestIDExists(guestId)) {
            return GuestResponse.GUEST_WITH_ID_DOES_NOT_EXIST.getMessage();
        } else {
            stayInfoRepository.checkOutGuestFromRoom(guestsRepository.getGuestById(guestId),
                    roomsRepository.getRoomByNumber(roomId));
            logger.info(String.format("Выселение гостя c id: %d, из номера с id: %d", guestId, roomId));
            return GuestResponse.GUEST_EVICTED_FROM_ROOM.getMessage();
        }
    }

    @Override
    public String getLastNameGuestById(int guestId) {
        return guestsRepository.getGuestById(guestId).getLastName();
    }

    @Override
    public String deletedGuestById(int guestId) {

        if (!guestsRepository.checkGuestIDExists(guestId)) {
            return GuestResponse.GUEST_WITH_ID_DOES_NOT_EXIST.getMessage();
        } else {
            guestsRepository.deleteGuest(guestsRepository.getGuestById(guestId));
            logger.info(String.format("Удален посетитель с id: %d ", guestId));
            return GuestResponse.GUEST_DELETED.getMessage();
        }
    }

    @Override
    public String exportGuestsToFileCSV() {
        if (guestsRepository.getAllGuests().isEmpty()) {
            logger.info(GuestResponse.EXPORT_GUESTS_NOK.getMessage());
            return GuestResponse.EXPORT_GUESTS_NOK.getMessage();
        } else {
            guestsRepository.exportGuestsToFileCSV();
            logger.info(GuestResponse.EXPORT_GUESTS_OK.getMessage());
            return GuestResponse.EXPORT_GUESTS_OK.getMessage();
        }
    }

    @Override
    public String importCSVFilesToGuests() {
        try {
            guestsRepository.importCSVFilesToGuests();
            logger.info(GuestResponse.IMPORT_GUESTS_OK.getMessage());
            return GuestResponse.IMPORT_GUESTS_OK.getMessage();
        } catch (Exception e) {
            logger.warn(GuestResponse.IMPORT_GUESTS_NOK.getMessage(), e);
            return GuestResponse.IMPORT_GUESTS_NOK.getMessage();
        }
    }

    @Override
    public String printServicesOneGuest(int guestId) {
        try {
            if (guestsRepository.checkGuestIDExists(guestId)) {
                StringBuilder str = new StringBuilder();
                List<Service> listService = guestsRepository.getGuestServices(
                        guestsRepository.getGuestById(guestId));

                str.append("Имя гостя: " + guestsRepository.getGuestById(guestId).getLastName() + "\n");
                str.append("Воспользовался услугами: " + "\n");
                str.append(listService.toString());
                return str.toString();
            } else {
                return GuestResponse.GUEST_WITH_ID_DOES_NOT_EXIST.getMessage();
            }
        } catch (Exception e) {
            System.out.println(GuestResponse.ERROR_PRINTING_GUEST_SERVICES.getMessage() + e.getMessage());
            return GuestResponse.ERROR_PRINTING_GUEST_SERVICES.getMessage();
        }
    }

    @Override
    public List<Service> getListServicesOneGuestSortPriceByGuestId(int guestId) {
        return servicesRepository.getListServicesSortByPriceOneGuest(
                guestsRepository.getGuestServices(guestsRepository.getGuestById(guestId)));
    }

    @Override
    public List<Guest> getListSortedGuestsByAlphabet() {
        return guestsRepository.getSortedGuestsByAlphabet();
    }

    @Override
    public void serializerGuests() {
        guestsRepository.serializerGuests();
    }

    @Override
    public void deserializeGuests() {
        guestsRepository.deserializeGuests();
    }
}