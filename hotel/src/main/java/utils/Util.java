package utils;

import models.Service;
import models.StayInfo;

import java.util.List;

public class Util {
    public static double calculateServicesCost(StayInfo stayInfo) {
        List<Service> services = stayInfo.getGuest().getServices();
        if (services.isEmpty()) {
            return 0.0;
        }
        return services.stream()
                .mapToDouble(Service::getPrice)
                .sum();
    }
}
