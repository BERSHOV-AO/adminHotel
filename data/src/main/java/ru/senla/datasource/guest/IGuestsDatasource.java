package ru.senla.datasource.guest;

import ru.senla.entities.Guest;

import java.util.List;

public interface IGuestsDatasource {
    public void addGuest(Guest guest);

    public void setGuests(List<Guest> guests);

    public List<Guest> getGuests();

    public void deleteGuest(Guest guest);
}
