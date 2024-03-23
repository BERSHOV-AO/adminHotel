package ru.senla.utils.csv_utils;


import ru.senla.entities.StayInfo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class StayInfoExporter {

    private static final String FILE_PATH = "resources/data_csv/stay_info.csv";

    public static void exportStayInfo(Map<Integer, StayInfo> infoStorage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Map.Entry<Integer, StayInfo> entry : infoStorage.entrySet()) {
                Integer key = entry.getKey();
                StayInfo stayInfo = entry.getValue();
                String csvLine = convertToCsv(key, stayInfo);
                writer.write(csvLine);
                writer.newLine();
                System.out.println("write ok");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String convertToCsv(Integer numberRoomKey, StayInfo stayInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(numberRoomKey).append(",");
        sb.append(stayInfo.getId()).append(",");
        sb.append(stayInfo.getGuest().getId()).append(",");
        sb.append(stayInfo.getGuest().getLastName()).append(",");
        sb.append(stayInfo.getCheckInDate()).append(",");
        sb.append(stayInfo.getCheckOutDate());
        return sb.toString();
    }
}
