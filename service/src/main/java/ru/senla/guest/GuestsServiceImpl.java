package ru.senla.guest;

import ru.senla.repository.guest.GuestsRepositoryImpl;
import ru.senla.repository.guest.IGuestsRepository;
import ru.senla.repository.service.IServicesRepository;
import ru.senla.repository.service.ServicesRepositoryImpl;

public class GuestsServiceImpl implements IGuestsService {
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
    public boolean AddServicesToGuest(int roomId, int serviceId) {

        if (guestsRepository.checkGuestIDExists(roomId) && servicesRepository.checkServiceIDExists(serviceId)) {
            return true;
        } else {
            return false;
        }

    }

}
