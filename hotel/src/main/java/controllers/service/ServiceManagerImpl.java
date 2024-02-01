package controllers.service;

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
}
