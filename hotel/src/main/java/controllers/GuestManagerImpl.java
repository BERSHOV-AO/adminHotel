package controllers;

import api.controllers.GuestManager;
import models.Guest;
import storages.GuestStorageImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GuestManagerImpl implements GuestManager {

    public GuestManagerImpl() {
    }

    @Override
    public void addOnGuest(Guest guest) {
        GuestStorageImpl.getInstance().addGuest(guest);
    }

    @Override
    public void deleteGuest(Guest guest) {
        GuestStorageImpl.getInstance().deleteGuest(guest);
    }

    @Override
    public void printGuest() {
        List<Guest> tempGuest = GuestStorageImpl.getInstance().getGuests();
        for (Guest guest : tempGuest) {
            System.out.println(guest);
        }
    }

    @Override
    public List<Guest> getSortedGuestsByAlphabet() {
        return GuestStorageImpl.getInstance().getGuests().stream()
                .sorted(Comparator.comparing(Guest::getLastName))
                .collect(Collectors.toList());
    }
}
