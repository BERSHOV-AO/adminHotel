package models;

import enums.ServiceType;
import utils.RandomNumber;

public class Service implements Entity {

    private int id;
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
        this.id = RandomNumber.getRandomID();
    }

    public Service(int id, ServiceType serviceType, double price) {
        this.serviceType = serviceType;
        this.price = price;
        this.id = id;
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
                "id=" + id +
                ", serviceType=" + serviceType +
                ", price=" + price +
                '}';
    }
}