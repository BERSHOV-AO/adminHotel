package storages;

import models.Guest;
import models.Room;

import java.util.ArrayList;
import java.util.List;

public class GuestStorage {

    private List<Guest> guests = new ArrayList<>();

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void deleteGuest(Guest guest) {
        guests.remove(guest);
    }
}
