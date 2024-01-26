package managers;

import models.Service;
import storages.ServicesStorage;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceManager {

    ServicesStorage servicesStorage = new ServicesStorage();

    public void addService(Service service) {
        servicesStorage.addService(service);
    }

    public void printService() {
        List<Service> tempService = servicesStorage.getServices();
        for (Service service : tempService) {
            System.out.println(service);
        }
    }

    public void changeServicePrice(Service service, double price) {
        servicesStorage.getServices().stream()
                .filter(r -> r.getServiceType() == service.getServiceType())
                .findFirst()
                .ifPresent(r -> {
                    r.setPrice(price);
                });
    }

    public List<Service> sortByPrice() {
        return servicesStorage.getServices().stream()
                .sorted(Comparator.comparingDouble(Service::getPrice))
                .collect(Collectors.toList());
    }

    public List<Service> sortBySection() {
        return servicesStorage.getServices().stream()
                .sorted(Comparator.comparing(service -> service.getServiceType().name()))
                .collect(Collectors.toList());
    }
}
