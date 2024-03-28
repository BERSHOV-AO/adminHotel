package ru.senla.service;

import org.apache.log4j.Logger;
import ru.senla.di.InjectByType;
import ru.senla.di.Singleton;
import ru.senla.entities.Service;
import ru.senla.enums.response.ServiceResponse;
import ru.senla.enums.ServiceType;
import ru.senla.repository.service.IServicesRepository;

import java.util.List;

@Singleton
public class ServicesServiceImpl implements IServicesService {

    final static Logger logger = Logger.getLogger(ServicesServiceImpl.class);

//    @InjectDependency(ConfigurationType.REPOSITORY_SERVICE)
//    IServicesRepository servicesRepository;
//IServicesRepository servicesRepository = ServicesRepositoryImpl.getInstance();

    @InjectByType
    IServicesRepository servicesRepository; // = ObjectFactory.getInstance().createObject(IServicesRepository.class);

//    private static ServicesServiceImpl instance;

    public ServicesServiceImpl() {
    }

//    public static ServicesServiceImpl getInstance() {
//        if (instance == null) {
//            instance = new ServicesServiceImpl();
//        }
//        return instance;
//    }

    @Override
    public List<Service> getListServices() {
        return servicesRepository.getAllServices();
    }

    @Override
    public String addService(ServiceType serviceType, Double servicePrice) {

        try {
            servicesRepository.addService(new Service(serviceType, servicePrice));
            logger.info(String.format("Добавлен сервис: %s, цена: %.2f", serviceType, servicePrice));
            return ServiceResponse.SERVICE_ADDED.getMessage();
        } catch (Exception e) {

            logger.warn(ServiceResponse.ERROR_SERVICE_ADDED.getMessage(), e);
            return ServiceResponse.ERROR_SERVICE_ADDED.getMessage();
        }
    }

    @Override
    public String changeServicePrice(int serviceId, Double servicePriceNew) {

        try {
            if (servicesRepository.checkServiceIDExists(serviceId)) {
                servicesRepository.changeServicePrice(servicesRepository.getServiceById(serviceId), servicePriceNew);
                logger.info(String.format("Стоимость сервиса с id %d, изменена на: %.2f", serviceId, servicePriceNew));
                return ServiceResponse.SERVICE_PRICE_CHANGE_OK.getMessage();
            } else {
                logger.warn(ServiceResponse.SERVICE_WITH_ID_DOES_NOT_EXIST.getMessage());
                return ServiceResponse.SERVICE_WITH_ID_DOES_NOT_EXIST.getMessage();
            }
        } catch (Exception e) {
            logger.error(ServiceResponse.ERROR_SERVICE_PRICE_CHANGE_NOK.getMessage());
            return ServiceResponse.ERROR_SERVICE_PRICE_CHANGE_NOK.getMessage();
        }
    }

    @Override
    public String deleteService(int serviceId) {

        try {
            if (servicesRepository.getAllServices().isEmpty()) {
                return ServiceResponse.NO_SERVICES_AVAILABLE.toString();
            }
            if (servicesRepository.checkServiceIDExists(serviceId)) {
                servicesRepository.deleteService(servicesRepository.getServiceById(serviceId));
                logger.info(String.format("Удален сервис с id: %d", serviceId));
                return ServiceResponse.DELETED_SERVICE.getMessage();
            } else {
                return ServiceResponse.SERVICE_WITH_ID_DOES_NOT_EXIST.getMessage();
            }
        } catch (Exception e) {
            logger.warn(ServiceResponse.ERROR_DELETED_SERVICE.getMessage(), e);
            return ServiceResponse.ERROR_DELETED_SERVICE.getMessage();
        }
    }

    @Override
    public String exportServicesToFileCSV() {

        try {
            if (servicesRepository.getAllServices().isEmpty()) {
                logger.info(ServiceResponse.EXPORT_SERVICES_NOK.getMessage());
                return ServiceResponse.EXPORT_SERVICES_NOK.getMessage();
            } else {
                servicesRepository.exportServicesToFileCSV();
                logger.info(ServiceResponse.EXPORT_SERVICES_OK.getMessage());
                return ServiceResponse.EXPORT_SERVICES_OK.getMessage();
            }
        } catch (Exception e) {
            logger.warn(ServiceResponse.ERROR_EXPORT_SERVICES.getMessage(), e);
            return (ServiceResponse.ERROR_EXPORT_SERVICES.getMessage());
        }
    }

    @Override
    public String importCSVFilesToServices() {
        try {
            servicesRepository.importCSVFilesToServices();
            logger.info(ServiceResponse.IMPORT_SERVICES_OK.getMessage());
            return ServiceResponse.IMPORT_SERVICES_OK.getMessage();
        } catch (Exception e) {
            logger.warn(ServiceResponse.ERROR_IMPORT_SERVICES.getMessage(), e);
            return ServiceResponse.ERROR_IMPORT_SERVICES.getMessage();
        }
    }

    @Override
    public List<Service> printServices() {
        return servicesRepository.getAllServices();
    }

    @Override
    public List<Service> getListSortedServiceByAlphabet() {
        return servicesRepository.getListSortBySection();
    }

    @Override
    public List<Service> getListSortedServiceByPrice() {
        return servicesRepository.getListSortByPrice();
    }

    @Override
    public void serializerServices() {
        servicesRepository.serializerServices();
    }

    @Override
    public void deserializeServices() {
        servicesRepository.deserializeServices();
    }
}
