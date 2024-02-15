package ru.senla.enums;

public enum ServiceType {
    BREAKFAST(1),
    LUNCH(2),
    DINNER(3),
    LAUNDRY(4);

    private int id;

    ServiceType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static ServiceType integerServiceType(Integer input) {
        ServiceType serviceType = null;

        for (ServiceType service : ServiceType.values()) {
            if (service.getId() == input) {
                serviceType = service;
                break;
            }
        }
        return serviceType;
    }
}