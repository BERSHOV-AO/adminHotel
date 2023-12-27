package api.storages;

import models.Service;

import java.util.List;

public interface ServicesStorage {

    public void addService(Service service);

    public void setServices(List<Service> services);

    public List<Service> getServices();
}
