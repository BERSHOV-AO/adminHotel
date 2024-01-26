package storages;

import models.Service;

import java.util.ArrayList;
import java.util.List;

public class ServicesStorage {
    public List<Service> services = new ArrayList<>();

    public void addService(Service service) {
        services.add(service);
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Service> getServices() {
        return services;
    }
}
