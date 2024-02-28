package ru.senla.service;

import ru.senla.entities.Service;
import ru.senla.enums.ServiceType;

import java.util.List;

public interface IServicesService {

    public List<Service> getListServices();

    public String addService(ServiceType serviceType, Double servicePrice);

    public String changeServicePrice(int serviceId, Double servicePriceNew);

    public String deleteService(int serviceId);

    public String exportServicesToFileCSV();

    public String importCSVFilesToServices();

    public List<Service> printServices();

    public List<Service> getListSortedServiceByAlphabet();

    public List<Service> getListSortedServiceByPrice();
}
