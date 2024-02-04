package csv_utils;

import enums.ServiceType;
import models.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceImporterExporter {
    private static final String FILE_PATH = "resources/service.csv";

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
        List<Service> services = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Service service = convertFromCsv(line);
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

        //public Service(int id, ServiceType serviceType, double price) {
        Service service = new Service(id, serviceType, price);
        return service;
    }
}
