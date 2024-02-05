package csv_utils;

import controllers.guest.GuestManagerImpl;
import models.Guest;
import models.StayInfo;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class StayInfoImporterExporter {

    private static GuestManagerImpl guestManager = GuestManagerImpl.getInstance();
    private static final String FILE_PATH = "resources/stay_info.csv";

    public static void exportStayInfo(Map<Integer, StayInfo> infoStorage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Map.Entry<Integer, StayInfo> entry : infoStorage.entrySet()) {
                Integer key = entry.getKey();
                StayInfo stayInfo = entry.getValue();
                String csvLine = convertToCsv(key, stayInfo);
                System.out.println("csvLine: " + csvLine);
                writer.write(csvLine);
                writer.newLine();
                System.out.println("write ok");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Integer, StayInfo> importStayInfo() {
        Map<Integer, StayInfo> infoStorage = new LinkedHashMap<>();
        StayInfo stayInfo = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] fields = line.split(",");
                Integer numberRoomKey = Integer.parseInt(fields[0]);
                stayInfo = convertFromCsv(line);
                infoStorage.put(numberRoomKey, stayInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return infoStorage;
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

        private static StayInfo convertFromCsv(String csvLine) {
        String[] fields = csvLine.split(",");
        Integer numberRoomKey = Integer.parseInt(fields[0]);
        int idStayInfo = Integer.parseInt(fields[1]);
        int idGuest = Integer.parseInt(fields[2]);
        String lastNameGuest = fields[3];
        LocalDate checkInDate = LocalDate.parse(fields[4]);
        LocalDate checkOutDate = LocalDate.parse(fields[5]);

        if (guestManager.getGuestById(idGuest) == null) {
          return new StayInfo(idStayInfo, new Guest(lastNameGuest, idGuest),checkInDate, checkOutDate);

        } else {

            return new StayInfo(idStayInfo, guestManager.getGuestById(idGuest), checkInDate, checkOutDate);
        }
    }
}
