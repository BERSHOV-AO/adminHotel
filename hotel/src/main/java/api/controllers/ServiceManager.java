package api.controllers;

import models.Service;

import java.util.List;

public interface ServiceManager {
    public void addService(Service service);

    public void printService();

    public void changeServicePrice(Service service, double price);

    public List<Service> sortByPrice();

    public List<Service> sortBySection();
}
