package controllers.service;

import enums.ServiceType;
import models.Service;

import java.util.List;

public interface ServiceManager {
    public void addService(Service service);

    public void printService();

    public void changeServicePrice(Service service, double price);

    public List<Service> sortByPrice();

    public List<Service> sortBySection();

    public Service getServiceByType(ServiceType serviceType);

    public void deleteService(Service service);

    public List<Service> sortByPriceOneGuest(List<Service> serviceList);

}
