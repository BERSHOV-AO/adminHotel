package api.storages;

import models.Guest;

import java.util.List;

public interface GuestStorage {
    public void addGuest(Guest guest);

    public void setGuests(List<Guest> guests);

    public List<Guest> getGuests();

    public void deleteGuest(Guest guest);
}
