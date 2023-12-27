package storages;

import api.storages.GuestStorage;
import models.Guest;

import java.util.ArrayList;
import java.util.List;

public class GuestStorageImpl implements GuestStorage {

    private List<Guest> guests = new ArrayList<>();

    private static GuestStorageImpl instance;

    private GuestStorageImpl() {
    }

    public static GuestStorageImpl getInstance() {
        if (instance == null) {
            instance = new GuestStorageImpl();
        }
        return instance;
    }

    @Override
    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    @Override
    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    @Override
    public List<Guest> getGuests() {
        return guests;
    }

    @Override
    public void deleteGuest(Guest guest) {
        guests.remove(guest);
    }
}
