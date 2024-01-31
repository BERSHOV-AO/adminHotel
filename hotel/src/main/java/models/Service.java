package models;

import enums.ServiceType;

public class Service {

    private int id = 0;
    private ServiceType serviceType;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Service(ServiceType serviceType, double price) {
        this.serviceType = serviceType;
        this.price = price;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceType=" + serviceType +
                ", price=" + price +
                '}';
    }
}