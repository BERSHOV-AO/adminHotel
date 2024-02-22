package ru.senla.service;

import org.apache.log4j.Logger;
import ru.senla.entities.Service;
import ru.senla.guest.GuestsServiceImpl;
import ru.senla.repository.service.IServicesRepository;
import ru.senla.repository.service.ServicesRepositoryImpl;

import java.util.List;

public class ServicesServiceImpl implements IServicesService {

    final static Logger logger = Logger.getLogger(ServicesServiceImpl.class);
    IServicesRepository servicesRepository = ServicesRepositoryImpl.getInstance();

    private static ServicesServiceImpl instance;

    private ServicesServiceImpl() {
    }

    public static ServicesServiceImpl getInstance() {
        if (instance == null) {
            instance = new ServicesServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Service> getListServices() {
        return servicesRepository.getAllServices();
    }
}
