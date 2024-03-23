package ru.senla.utils.csv_utils;

import ru.senla.entities.Guest;

import java.util.List;

public class GuestImportExport {

    private static final String FILE_PATH = "resources/data_csv/guest.csv";

    private static String convertToCsv(Guest guest) {
        StringBuilder sb = new StringBuilder();
        sb.append(guest.getId()).append(",");
        sb.append(guest.getLastName());
        return sb.toString();
    }

    private static Guest convertFromCsv(String csvLine) {
        String[] fields = csvLine.split(",");
        int id = Integer.parseInt(fields[0]);
        String lastName = fields[1];

        Guest guest = new Guest(lastName, id);
        return guest;
    }

    public static void exportGuests(List<Guest> guests) {
        ExporterImporter<Guest> exporter = new ExporterImporter<>();
        exporter.export(guests, FILE_PATH, GuestImportExport::convertToCsv);
    }

    public static List<Guest> importGuests() {
        ExporterImporter<Guest> importer = new ExporterImporter<>();
        return importer.importData(FILE_PATH, GuestImportExport::convertFromCsv);
    }
}
