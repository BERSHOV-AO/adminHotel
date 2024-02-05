package csv_utils;

import controllers.room.RoomManagerImpl;
import enums.RoomStatus;
import models.Room;

import java.io.*;

import java.util.Iterator;
import java.util.List;

public class RoomImporterExporter {
    private static final String FILE_PATH = "resources/rooms.csv";
    private static RoomManagerImpl roomManager = RoomManagerImpl.getInstance();

    public static void exportRooms(List<Room> rooms) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Room room : rooms) {
                String csvLine = convertToCsv(room);
                writer.write(csvLine);
                writer.newLine();
                System.out.println("write ok");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Room> importRooms() {
        List<Room> rooms = roomManager.getAllRooms();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Room room = convertFromCsv(line);
                Iterator<Room> iterator = rooms.iterator();
                while (iterator.hasNext()) {
                    Room tempRoom = iterator.next();
                    if (tempRoom.getId() == room.getId()) {
                        iterator.remove();
                        break;
                    }
                }
                rooms.add(room);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rooms;
    }

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

        // public Room(int id, Integer roomNumber, int stars, double price, int capacity, RoomStatus status) {
        Room room = new Room(id, roomNumber, stars, price, capacity, roomStatus);
        return room;
    }
}
