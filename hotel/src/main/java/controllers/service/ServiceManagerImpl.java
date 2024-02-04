package controllers.service;

import csv_utils.ServiceImporterExporter;
import enums.ServiceType;
import models.*;
import storages.service.ServicesStorageImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceManagerImpl implements ServiceManager {

    ServicesStorageImpl servicesStorage = ServicesStorageImpl.getInstance();

    private static ServiceManagerImpl instance;

    private ServiceManagerImpl() {
    }

    public static ServiceManagerImpl getInstance() {
        if (instance == null) {
            instance = new ServiceManagerImpl();
        }
        return instance;
    }

    @Override
    public void addService(Service service) {
        servicesStorage.addService(service);
    }

    public void setServices(List<Service> services) {
        servicesStorage.setServices(services);
    }

    @Override
    public List<Service> getAllServices() {
        return servicesStorage.getServices();
    }

    @Override
    public void changeServicePrice(Service service, double price) {
        servicesStorage.getServices().stream()
                .filter(r -> r.getServiceType() == service.getServiceType())
                .findFirst()
                .ifPresent(r -> {
                    r.setPrice(price);
                });
    }

    @Override
    public List<Service> getListSortByPrice() {
        return servicesStorage.getServices().stream()
                .sorted(Comparator.comparingDouble(Service::getPrice))
                .collect(Collectors.toList());
    }

    public List<Service> getListServicesSortByPriceOneGuest(List<Service> serviceList) {

        System.out.println("serviceList: " + serviceList);
        return serviceList.stream()
                .sorted(Comparator.comparingDouble(Service::getPrice))
                .collect(Collectors.toList());
    }


    @Override
    public List<Service> getListSortBySection() {
        return servicesStorage.getServices().stream()
                .sorted(Comparator.comparing(service -> service.getServiceType().name()))
                .collect(Collectors.toList());
    }

    @Override
    public Service getServiceByType(ServiceType serviceType) {
        return servicesStorage.getServices().stream()
                .filter(service -> service.getServiceType().equals(serviceType))
                .findFirst()
                .orElse(null);
    }


    public Service getServiceById(int id) {
        return servicesStorage.getServices().stream()
                .filter(service -> (service.getId() == id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteService(Service service) {
        servicesStorage.deleteService(service);
    }

    public boolean checkServiceIDExists(int serviceId) {
        return servicesStorage.getServices().stream()
                .anyMatch(service -> service.getId() == serviceId);
    }

    public boolean existsServices() {
        List<Service> services = servicesStorage.getServices();
        return !services.isEmpty();
    }

    public void exportServicesToFileCSV() {
        ServiceImporterExporter.exportServices(servicesStorage.getServices());
    }

    public void importCSVFilesToServices() {
        servicesStorage.setServices(ServiceImporterExporter.importServices());
    }
}
