package ru.senla.datasource.service;

import ru.senla.di.Singleton;
import ru.senla.entities.Service;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class ServicesDatasourceImpl implements IServicesDatasource {

    public List<Service> services = new ArrayList<>();

    public ServicesDatasourceImpl() {
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

    @Override
    public void deleteService(Service service) {
        services.remove(service);
    }
}
