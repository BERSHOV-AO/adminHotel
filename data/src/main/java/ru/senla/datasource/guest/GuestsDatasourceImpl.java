package ru.senla.datasource.guest;

import ru.senla.annotations.di.Singleton;
import ru.senla.entities.Guest;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class GuestsDatasourceImpl implements IGuestsDatasource {

    private List<Guest> guests = new ArrayList<>();

    private static GuestsDatasourceImpl instance;

    private GuestsDatasourceImpl() {
    }

    public static GuestsDatasourceImpl getInstance() {
        if (instance == null) {
            instance = new GuestsDatasourceImpl();
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
