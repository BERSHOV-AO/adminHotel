package ru.senla.guest;

import ru.senla.entities.Guest;
import ru.senla.entities.Service;

import java.time.LocalDate;
import java.util.List;

public interface IGuestsService {

    public String addServicesToGuest(int roomId, int serviceId);

    public List<Guest> getListGuests();

    public String addGuest(String lastName);

    public Guest getGuestByID(int guestId);

    public String billGuest();

    public String checkInGuest(int guestId, int roomId, LocalDate inDate, LocalDate outDate);

    public String checkOutGuest(int guestId, int roomId);

    public String getLastNameGuestById(int guestId);

    public String deletedGuestById(int guestId);

    public String exportGuestsToFileCSV();

    public String importCSVFilesToGuests();

    public String printServicesOneGuest(int guestId);

    public List<Service> getListServicesOneGuestSortPriceByGuestId(int guestId);

    public List<Guest> getListSortedGuestsByAlphabet();
}
