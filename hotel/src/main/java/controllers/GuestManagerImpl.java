package controllers;

import api.controllers.GuestManager;
import models.Guest;
import models.Room;
import models.Service;
import storages.GuestStorageImpl;
import storages.RoomsStorageImpl;

import java.util.ArrayList;
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
        System.out.println("----Список посетителей----");
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

    @Override
    public Guest getGuestByName(String lastName) {
        return GuestStorageImpl.getInstance().getGuests().stream()
                .filter(guest -> guest.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }

    // add Service to Guests
    @Override
    public void addServicesToGuest(Guest guest, Service service) {

        System.out.println("addServicesToGuest " + service);
        List<Guest> tempListGuests = GuestStorageImpl.getInstance().getGuests();

        for (Guest tempGuest : tempListGuests) {
            if (tempGuest.getLastName().equals(guest.getLastName())) {
                List<Service> tempListService = new ArrayList<>();

                if (tempGuest.getServices() != null) {
                    tempListService = tempGuest.getServices();
                }
                tempListService.add(service);
                tempGuest.setServices(tempListService);
                break;
            }
            GuestStorageImpl.getInstance().setGuests(tempListGuests);
        }
    }


    @Override
    public List<Service> getGuestServices(Guest guest) {
        List<Guest> tempListGuests = GuestStorageImpl.getInstance().getGuests();
        List<Service> tempListService = new ArrayList<>();

        for (Guest tempGuest : tempListGuests) {
            if (tempGuest.getLastName().equals(guest.getLastName())) {
                tempListService = guest.getServices();
                break;
            }
        }
        return tempListService;
    }
}



