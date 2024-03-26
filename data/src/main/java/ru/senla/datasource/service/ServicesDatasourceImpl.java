package ru.senla.datasource.service;

import ru.senla.di_factory.Singleton;
import ru.senla.entities.Service;

import java.util.ArrayList;
import java.util.List;
@Singleton
public class ServicesDatasourceImpl implements IServicesDatasource {

    public List<Service> services = new ArrayList<>();

    private static ServicesDatasourceImpl instance;

    public ServicesDatasourceImpl() {
    }

    public static ServicesDatasourceImpl getInstance() {
        if (instance == null) {
            instance = new ServicesDatasourceImpl();
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

    @Override
    public void deleteService(Service service) {
        services.remove(service);
    }
}
