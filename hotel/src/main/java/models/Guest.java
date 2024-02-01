package models;

import utils.RandomNumber;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Guest {
    private int id;
    private String lastName;
    private List<Service> services;
    public Guest(String lastName) {
        this.lastName = lastName;
        this.id = RandomNumber.getRandomID();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }


    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", services=" + services +
                '}';
    }
}
