package controllers.guest;

import models.Guest;
import models.Service;
import storages.guest.GuestStorageImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GuestManagerImpl implements GuestManager {

    GuestStorageImpl guestStorage = GuestStorageImpl.getInstance();

    private static GuestManagerImpl instance;

    private GuestManagerImpl() {
    }

    public static GuestManagerImpl getInstance() {
        if (instance == null) {
            instance = new GuestManagerImpl();
        }
        return instance;
    }

    @Override
    public void addOnGuest(Guest guest) {
        guestStorage.addGuest(guest);
    }

    @Override
    public void deleteGuest(Guest guest) {
        guestStorage.deleteGuest(guest);
    }

    @Override
    public List<Guest> getAllGuests() {
        return guestStorage.getGuests();
    }

    @Override
    public List<Guest> getSortedGuestsByAlphabet() {
        return guestStorage.getGuests().stream()
                .sorted(Comparator.comparing(Guest::getLastName))
                .collect(Collectors.toList());
    }

    @Override
    public Guest getGuestByName(String lastName) {
        return guestStorage.getGuests().stream()
                .filter(guest -> guest.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addServicesToGuest(Guest guest, Service service) {
        List<Guest> tempListGuests = guestStorage.getGuests();
        for (Guest tempGuest : tempListGuests) {
            if (tempGuest.getLastName().equals(guest.getLastName())) {
                List<Service> tempListService = new ArrayList<>();

                if (tempGuest.getServices() != null) {
                    tempListService = tempGuest.getServices();
                }
                tempListService.add(service);
                tempGuest.setServices(tempListService);
                break;
            }
            guestStorage.setGuests(tempListGuests);
        }
    }

    @Override
    public List<Service> getGuestServices(Guest guest) {
        List<Guest> tempListGuests = guestStorage.getGuests();
        List<Service> tempListService = new ArrayList<>();

        for (Guest tempGuest : tempListGuests) {
            if (tempGuest.getLastName().equals(guest.getLastName())) {
                tempListService = guest.getServices();
                break;
            }
        }
        return tempListService;
    }
}


