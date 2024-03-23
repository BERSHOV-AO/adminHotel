package ru.senla.repository.guest;

import ru.senla.entities.Guest;
import ru.senla.entities.Service;

import java.util.List;

public interface IGuestsRepository {
    public void addOnGuest(Guest guest);

    public void setGuests(List<Guest> guests);

    public void deleteGuest(Guest guest);

    public Guest getGuestById(int id);

    public List<Guest> getAllGuests();

    public List<Guest> getSortedGuestsByAlphabet();

    public Guest getGuestByName(String lastName);

    public void addServicesToGuest(Guest guest, Service service);

    public List<Service> getGuestServices(Guest guest);

    public boolean checkGuestIDExists(int guestId);

    public void exportGuestsToFileCSV();

    public void importCSVFilesToGuests();

    public void serializerGuests();

    public void deserializeGuests();
}
