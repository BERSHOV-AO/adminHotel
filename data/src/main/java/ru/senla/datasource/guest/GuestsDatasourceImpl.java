package ru.senla.datasource.guest;

import ru.senla.di_factory.Singleton;
import ru.senla.entities.Guest;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class GuestsDatasourceImpl implements IGuestsDatasource {

    private List<Guest> guests = new ArrayList<>();

    public GuestsDatasourceImpl() {
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
