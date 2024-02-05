package csv_utils;

import controllers.service.ServiceManagerImpl;
import enums.ServiceType;
import models.Room;
import models.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServiceImporterExporter {
    private static final String FILE_PATH = "resources/service.csv";
    private static ServiceManagerImpl serviceManager = ServiceManagerImpl.getInstance();

    public static void exportServices(List<Service> services) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Service service : services) {
                String csvLine = convertToCsv(service);
                writer.write(csvLine);
                writer.newLine();
                System.out.println("write ok");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Service> importServices() {
        List<Service> services = serviceManager.getAllServices();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Service service = convertFromCsv(line);
                Iterator<Service> iterator = services.iterator();
                while (iterator.hasNext()) {
                    Service tempService = iterator.next();
                    if (tempService.getId() == service.getId()) {
                        iterator.remove();
                        break;
                    }
                }
                services.add(service);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return services;
    }

    private static String convertToCsv(Service service) {
        StringBuilder sb = new StringBuilder();
        sb.append(service.getId()).append(",");
        sb.append(service.getServiceType()).append(",");
        sb.append(service.getPrice());
        return sb.toString();
    }

    private static Service convertFromCsv(String csvLine) {
        String[] fields = csvLine.split(",");
        int id = Integer.parseInt(fields[0]);
        ServiceType serviceType = ServiceType.valueOf(fields[1]);
        double price = Double.parseDouble(fields[2]);

        Service service = new Service(id, serviceType, price);
        return service;
    }
}
