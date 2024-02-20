package ru.senla.guest;

import ru.senla.entities.Guest;

import java.util.List;

public interface IGuestsService {

    public String AddServicesToGuest(int roomId, int serviceId);

    public List<Guest> getListGuests();


}
