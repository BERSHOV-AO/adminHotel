package controllers.guest;

import models.Guest;
import models.Service;

import java.util.List;

public interface GuestManager {
    public void addOnGuest(Guest guest);

    public void deleteGuest(Guest guest);

    public void printGuest();

    public List<Guest> getSortedGuestsByAlphabet();

    public Guest getGuestByName(String lastName);

    public void addServicesToGuest(Guest guest, Service service);

    public List<Service> getGuestServices(Guest guest);
}
