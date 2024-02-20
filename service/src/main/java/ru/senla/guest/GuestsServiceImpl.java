package ru.senla.guest;

import ru.senla.enums.GuestResponse;
import ru.senla.repository.guest.GuestsRepositoryImpl;
import ru.senla.repository.guest.IGuestsRepository;
import ru.senla.repository.service.IServicesRepository;
import ru.senla.repository.service.ServicesRepositoryImpl;

import org.apache.log4j.Logger;

public class GuestsServiceImpl implements IGuestsService {

    final static Logger logger = Logger.getLogger(GuestsServiceImpl.class);
    IGuestsRepository guestsRepository = GuestsRepositoryImpl.getInstance();
    IServicesRepository servicesRepository = ServicesRepositoryImpl.getInstance();

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
    public String AddServicesToGuest(int guestId, int serviceId) {

        if (guestsRepository.checkGuestIDExists(guestId) && servicesRepository.checkServiceIDExists(serviceId)) {
            guestsRepository.addServicesToGuest(guestsRepository.getGuestById(guestId),
                    servicesRepository.getServiceById(serviceId));
            logger.info(String.format("Посетителю с id: %d добавлена услуга с id: %d ", guestId, serviceId));
            return GuestResponse.SERVICE_ADDED.toString();
        } else {
            return GuestResponse.GUEST_NOT_ADDED.toString();
        }

    }

}
