package ru.senla.datasource.service;


import ru.senla.entities.Service;

import java.util.List;

public interface IServicesDatasource {
    public void addService(Service service);

    public void setServices(List<Service> services);

    public List<Service> getServices();

    public void deleteService(Service service);
}
