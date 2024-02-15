package ru.senla.repository.service;

import ru.senla.entities.Service;
import ru.senla.enums.ServiceType;

import java.util.List;

public interface IServicesRepository {
    public void addService(Service service);

    public List<Service> getAllServices();

    public void setServices(List<Service> services);

    public void changeServicePrice(Service service, double price);

    public List<Service> getListSortByPrice();

    public List<Service> getListSortBySection();

    public boolean checkServiceIDExists(int serviceId);

    public Service getServiceByType(ServiceType serviceType);

    public void deleteService(Service service);

    public List<Service> getListServicesSortByPriceOneGuest(List<Service> serviceList);

    public Service getServiceById(int id);

    public boolean existsServices();

    public void exportServicesToFileCSV();

    public void importCSVFilesToServices();
}
