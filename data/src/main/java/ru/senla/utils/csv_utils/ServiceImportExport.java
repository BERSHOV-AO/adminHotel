package ru.senla.utils.csv_utils;

import ru.senla.enums.ServiceType;
import ru.senla.entities.Service;

import java.util.List;

public class ServiceImportExport {

    private static final String FILE_PATH = "resources/service.csv";

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

    public static void exportServices(List<Service> services) {
        ExporterImporter<Service> exporter = new ExporterImporter<>();
        exporter.export(services, FILE_PATH, ServiceImportExport::convertToCsv);
    }

    public static List<Service> importServices() {
        ExporterImporter<Service> importer = new ExporterImporter<>();
        return importer.importData(FILE_PATH, ServiceImportExport::convertFromCsv);
    }
}
