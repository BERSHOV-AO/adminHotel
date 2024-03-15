package ru.senla.repository.guest;

import ru.senla.datasource.guest.GuestsDatasourceImpl;
import ru.senla.datasource.guest.IGuestsDatasource;
import ru.senla.entities.Guest;
import ru.senla.entities.Service;
import ru.senla.utils.csv_utils.GuestImportExport;
import ru.senla.utils.serialization.GuestsSerializeDeserialize;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GuestsRepositoryImpl implements IGuestsRepository {

    IGuestsDatasource guestsDatasource = GuestsDatasourceImpl.getInstance();

    private static GuestsRepositoryImpl instance;

    private GuestsRepositoryImpl() {
    }

    public static GuestsRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new GuestsRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void addOnGuest(Guest guest) {
        guestsDatasource.addGuest(guest);
    }

    @Override
    public void setGuests(List<Guest> guests) {
        guestsDatasource.setGuests(guests);
    }

    @Override
    public void deleteGuest(Guest guest) {
        guestsDatasource.deleteGuest(guest);
    }

    @Override
    public List<Guest> getAllGuests() {
        return guestsDatasource.getGuests();
    }

    @Override
    public List<Guest> getSortedGuestsByAlphabet() {
        return guestsDatasource.getGuests().stream()
                .sorted(Comparator.comparing(Guest::getLastName))
                .collect(Collectors.toList());
    }

    @Override
    public Guest getGuestByName(String lastName) {
        return guestsDatasource.getGuests().stream()
                .filter(guest -> guest.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Guest getGuestById(int id) {
        return guestsDatasource.getGuests().stream()
                .filter(guest -> (guest.getId() == id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addServicesToGuest(Guest guest, Service service) {
        List<Guest> tempListGuests = guestsDatasource.getGuests();
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
            guestsDatasource.setGuests(tempListGuests);
        }
    }

    @Override
    public List<Service> getGuestServices(Guest guest) {
        List<Guest> tempListGuests = guestsDatasource.getGuests();
        List<Service> tempListService = new ArrayList<>();

        for (Guest tempGuest : tempListGuests) {
            if (tempGuest.getLastName().equals(guest.getLastName())) {
                tempListService = guest.getServices();
                break;
            }
        }
        return tempListService;
    }

    @Override
    public boolean checkGuestIDExists(int guestId) {
        return guestsDatasource.getGuests().stream()
                .anyMatch(guest -> guest.getId() == guestId);
    }

    @Override
    public void exportGuestsToFileCSV() {
        GuestImportExport.exportGuests(guestsDatasource.getGuests());
    }

    @Override
    public void importCSVFilesToGuests() {
        guestsDatasource.setGuests(GuestImportExport.importGuests());
    }

    @Override
    public void serializerGuests() {
        GuestsSerializeDeserialize.serializeGuestsList(guestsDatasource.getGuests());
    }

    @Override
    public void deserializeGuests() {
        if (GuestsSerializeDeserialize.deserializeGuestsList() != null) {
            List<Guest> serializerListGuests = new ArrayList<>(GuestsSerializeDeserialize.deserializeGuestsList());
            guestsDatasource.setGuests(serializerListGuests);
        }
    }
}
