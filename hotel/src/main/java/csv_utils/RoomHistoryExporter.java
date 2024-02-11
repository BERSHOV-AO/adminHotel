package csv_utils;

import models.RoomHistory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoomHistoryExporter {

    private static final String FILE_PATH = "resources/rooms_history.csv";

    public static void exportOneRoomsHistory(RoomHistory roomHistory) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH,
                StandardCharsets.UTF_8, true))) {
            String csvLine = convertToCsv(roomHistory);
            writer.write(csvLine);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exportRoomsHistory(List<RoomHistory> listRoomsHistory) {
        Set<String> existingRecords = readExistingRecords();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH,
                StandardCharsets.UTF_8, true))) {
            for (RoomHistory roomHistory : listRoomsHistory) {
                String csvLine = convertToCsv(roomHistory);
                if (!existingRecords.contains(csvLine)) {
                    writer.write(csvLine);
                    writer.newLine();
                    existingRecords.add(csvLine);
                    System.out.println("Запись успешно добавлена в файл");
                } else {
                    System.out.println("Запись уже существует в файле");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Set<String> readExistingRecords() {
        Set<String> existingRecords = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                existingRecords.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return existingRecords;
    }

    private static String convertToCsv(RoomHistory roomHistory) {
        StringBuilder sb = new StringBuilder();
        sb.append(roomHistory.getId()).append(",");
        //------------room-----------
        sb.append(roomHistory.getRoom().getId()).append(",");
        sb.append(roomHistory.getRoom().getRoomNumber()).append(",");
        sb.append(roomHistory.getRoom().getStars()).append(",");
        sb.append(roomHistory.getRoom().getPrice()).append(",");
        sb.append(roomHistory.getRoom().getCapacity()).append(",");
        sb.append(roomHistory.getRoom().getStatus()).append(",");
        //-----------guest----------
        sb.append(roomHistory.getGuest().getId()).append(",");
        sb.append(roomHistory.getGuest().getLastName()).append(",");
        //--------------------------
        sb.append(roomHistory.getCheckInDate()).append(",");
        sb.append(roomHistory.getCheckOutDate()).append(",");
        sb.append(roomHistory.getStatus());
        return sb.toString();
    }
}


