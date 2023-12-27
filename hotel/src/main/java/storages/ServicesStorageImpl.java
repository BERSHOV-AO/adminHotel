package storages;

import api.storages.ServicesStorage;
import models.Service;

import java.util.ArrayList;
import java.util.List;

public class ServicesStorageImpl implements ServicesStorage {
    public List<Service> services = new ArrayList<>();

    private static ServicesStorageImpl instance;

    private ServicesStorageImpl() {
    }

    public static ServicesStorageImpl getInstance() {
        if (instance == null) {
            instance = new ServicesStorageImpl();
        }
        return instance;
    }

    @Override
    public void addService(Service service) {
        services.add(service);
    }

    @Override
    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    public List<Service> getServices() {
        return services;
    }
}
