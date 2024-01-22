package controllers.service;

import enums.ServiceType;
import models.*;
import storages.service.ServicesStorageImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceManagerImpl implements ServiceManager {

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
        ServicesStorageImpl.getInstance().addService(service);
    }

    @Override
    public List<Service> getAllServices() {
        return ServicesStorageImpl.getInstance().getServices();
    }

    @Override
    public void changeServicePrice(Service service, double price) {
        ServicesStorageImpl.getInstance().getServices().stream()
                .filter(r -> r.getServiceType() == service.getServiceType())
                .findFirst()
                .ifPresent(r -> {
                    r.setPrice(price);
                });
    }

    @Override
    public List<Service> getListSortByPrice() {
        return ServicesStorageImpl.getInstance().getServices().stream()
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
        return ServicesStorageImpl.getInstance().getServices().stream()
                .sorted(Comparator.comparing(service -> service.getServiceType().name()))
                .collect(Collectors.toList());
    }

    @Override
    public Service getServiceByType(ServiceType serviceType) {
        return ServicesStorageImpl.getInstance().getServices().stream()
                .filter(service -> service.getServiceType().equals(serviceType))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteService(Service service) {
        ServicesStorageImpl.getInstance().deleteService(service);
    }
}
