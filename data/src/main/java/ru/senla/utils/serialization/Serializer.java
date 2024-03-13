package ru.senla.utils.serialization;

import ru.senla.datasource.guest.GuestsDatasourceImpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializer {

    ObjectOutputStream oos;

    private Serializer(String path) {
        try {
            oos = new ObjectOutputStream(new FileOutputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serialize() {

        try {
            oos.writeObject(GuestsDatasourceImpl.getInstance().getGuests());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
