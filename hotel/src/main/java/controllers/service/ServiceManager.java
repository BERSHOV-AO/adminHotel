package controllers.service;

import enums.ServiceType;
import models.Service;

import java.util.List;

public interface ServiceManager {
    public void addService(Service service);

    public List<Service> getAllServices();

    public void changeServicePrice(Service service, double price);

    public List<Service> getListSortByPrice();

    public List<Service> getListSortBySection();

    public Service getServiceByType(ServiceType serviceType);

    public void deleteService(Service service);

    public List<Service> getListServicesSortByPriceOneGuest(List<Service> serviceList);

}