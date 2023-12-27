package api.controllers;

import models.Guest;

import java.util.List;

public interface GuestManager {
    public void addOnGuest(Guest guest);

    public void deleteGuest(Guest guest);

    public void printGuest();

    public List<Guest> getSortedGuestsByAlphabet();
}
