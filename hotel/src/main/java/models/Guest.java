package models;

import enums.ServiceType;

import java.util.List;

public class Guest {
    private int id = 0;
    private String lastName;
    private List<Service> services;

    public Guest(String lastName) {
        this.lastName = lastName;
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
                "lastName='" + lastName + '\'' +
                ", services=" + services +
                '}';
    }
}
