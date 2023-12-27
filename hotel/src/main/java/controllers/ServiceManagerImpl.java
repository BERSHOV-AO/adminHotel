package controllers;

import api.controllers.ServiceManager;
import models.Service;
import storages.ServicesStorageImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceManagerImpl implements ServiceManager {

    @Override
    public void addService(Service service) {
        ServicesStorageImpl.getInstance().addService(service);
    }

    @Override
    public void printService() {
        List<Service> tempService = ServicesStorageImpl.getInstance().getServices();
        for (Service service : tempService) {
            System.out.println(service);
        }
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
    public List<Service> sortByPrice() {
        return ServicesStorageImpl.getInstance().getServices().stream()
                .sorted(Comparator.comparingDouble(Service::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public List<Service> sortBySection() {
        return ServicesStorageImpl.getInstance().getServices().stream()
                .sorted(Comparator.comparing(service -> service.getServiceType().name()))
                .collect(Collectors.toList());
    }
}
