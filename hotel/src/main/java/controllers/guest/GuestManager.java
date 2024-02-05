package controllers.guest;

import models.Guest;
import models.Service;

import java.util.List;

public interface GuestManager {
    public void addOnGuest(Guest guest);

    public void setGuests(List<Guest> guests);

    public void deleteGuest(Guest guest);

    public List<Guest> getAllGuests();

    public List<Guest> getSortedGuestsByAlphabet();

    public Guest getGuestByName(String lastName);

    public void addServicesToGuest(Guest guest, Service service);

    public List<Service> getGuestServices(Guest guest);

    public boolean checkGuestIDExists(int guestId);

    public void exportGuestsToFileCSV();

    public void importCSVFilesToGuests();
}
