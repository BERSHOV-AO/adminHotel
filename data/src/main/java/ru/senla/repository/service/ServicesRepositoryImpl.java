package ru.senla.repository.service;

import ru.senla.ConfigurationType;
import ru.senla.InjectDependency;
import ru.senla.datasource.service.IServicesDatasource;
import ru.senla.entities.Service;
import ru.senla.enums.ServiceType;
import ru.senla.utils.csv_utils.ServiceImportExport;
import ru.senla.utils.serialization.ServicesSerializeDeserialize;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ServicesRepositoryImpl implements IServicesRepository {

    @InjectDependency(ConfigurationType.DATASOURCE_SERVICE)
    IServicesDatasource servicesDatasource;

    private static ServicesRepositoryImpl instance;

    private ServicesRepositoryImpl() {
    }

    public static ServicesRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ServicesRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void addService(Service service) {
        servicesDatasource.addService(service);
    }

    @Override
    public void setServices(List<Service> services) {
        servicesDatasource.setServices(services);
    }

    @Override
    public List<Service> getAllServices() {
        return servicesDatasource.getServices();
    }

    @Override
    public void changeServicePrice(Service service, double price) {
        servicesDatasource.getServices().stream()
                .filter(r -> r.getServiceType() == service.getServiceType())
                .findFirst()
                .ifPresent(r -> r.setPrice(price));
    }

    @Override
    public List<Service> getListSortByPrice() {
        return servicesDatasource.getServices().stream()
                .sorted(Comparator.comparingDouble(Service::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public List<Service> getListServicesSortByPriceOneGuest(List<Service> serviceList) {

        System.out.println("serviceList: " + serviceList);
        return serviceList.stream()
                .sorted(Comparator.comparingDouble(Service::getPrice))
                .collect(Collectors.toList());
    }


    @Override
    public List<Service> getListSortBySection() {
        return servicesDatasource.getServices().stream()
                .sorted(Comparator.comparing(service -> service.getServiceType().name()))
                .collect(Collectors.toList());
    }

    @Override
    public Service getServiceByType(ServiceType serviceType) {
        return servicesDatasource.getServices().stream()
                .filter(service -> service.getServiceType().equals(serviceType))
                .findFirst()
                .orElse(null);
    }


    @Override
    public Service getServiceById(int id) {
        return servicesDatasource.getServices().stream()
                .filter(service -> (service.getId() == id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteService(Service service) {
        servicesDatasource.deleteService(service);
    }

    @Override
    public boolean checkServiceIDExists(int serviceId) {
        return servicesDatasource.getServices().stream()
                .anyMatch(service -> service.getId() == serviceId);
    }

    @Override
    public boolean existsServices() {
        List<Service> services = servicesDatasource.getServices();
        return !services.isEmpty();
    }

    @Override
    public void exportServicesToFileCSV() {
        ServiceImportExport.exportServices(servicesDatasource.getServices());
    }

    @Override
    public void importCSVFilesToServices() {
        servicesDatasource.setServices(ServiceImportExport.importServices());
    }

    @Override
    public void serializerServices() {
        ServicesSerializeDeserialize.serializeServicesList(servicesDatasource.getServices());
    }

    @Override
    public void deserializeServices() {
        if (ServicesSerializeDeserialize.deserializeServicesList() != null) {
            List<Service> serializerListServices =
                    new ArrayList<>(ServicesSerializeDeserialize.deserializeServicesList());
            servicesDatasource.setServices(serializerListServices);
        }
    }
}
