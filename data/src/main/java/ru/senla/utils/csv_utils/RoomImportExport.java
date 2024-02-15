package ru.senla.utils.csv_utils;

import ru.senla.enums.RoomStatus;
import ru.senla.entities.Room;

import java.util.List;

public class RoomImportExport {

    private static final String FILE_PATH = "resources/rooms.csv";

    private static String convertToCsv(Room room) {
        StringBuilder sb = new StringBuilder();
        sb.append(room.getId()).append(",");
        sb.append(room.getRoomNumber()).append(",");
        sb.append(room.getCapacity()).append(",");
        sb.append(room.getPrice()).append(",");
        sb.append(room.getStars()).append(",");
        sb.append(room.getStatus());
        return sb.toString();
    }

    private static Room convertFromCsv(String csvLine) {
        String[] fields = csvLine.split(",");
        int id = Integer.parseInt(fields[0]);
        Integer roomNumber = Integer.parseInt(fields[1]);
        int capacity = Integer.parseInt(fields[2]);
        double price = Double.parseDouble(fields[3]);
        int stars = Integer.parseInt(fields[4]);
        RoomStatus roomStatus = RoomStatus.valueOf(fields[5]);

        Room room = new Room(id, roomNumber, stars, price, capacity, roomStatus);
        return room;
    }

    public static void exportRooms(List<Room> rooms) {
        ExporterImporter<Room> exporter = new ExporterImporter<>();
        exporter.export(rooms, FILE_PATH, RoomImportExport::convertToCsv);
    }

    public static List<Room> importRooms() {
        ExporterImporter<Room> importer = new ExporterImporter<>();
        return importer.importData(FILE_PATH, RoomImportExport::convertFromCsv);
    }
}
