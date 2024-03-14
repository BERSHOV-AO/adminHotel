package ru.senla.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.senla.utils.RandomNumber;

import java.util.List;

public class Guest implements Entity {
    private int id;
    private String lastName;
    private List<Service> services;

    public Guest(String lastName) {
        this.lastName = lastName;
        this.id = RandomNumber.getRandomID();
    }

    public Guest() {
    }

    public Guest(String lastName, int id) {
        this.lastName = lastName;
        this.id = id;
    }

    @JsonCreator
    public Guest(@JsonProperty("id") int id,
                 @JsonProperty("lastName") String lastName) {
        this.lastName = lastName;
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
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
