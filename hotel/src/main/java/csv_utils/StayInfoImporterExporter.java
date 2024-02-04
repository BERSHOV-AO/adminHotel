package csv_utils;

import controllers.guest.GuestManagerImpl;
import models.Service;
import models.StayInfo;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StayInfoImporterExporter {

    private static GuestManagerImpl guestManager = GuestManagerImpl.getInstance();

    private static final String FILE_PATH = "resources/stay_info.csv";

//    public static void exportStayInfo(StayInfo stayInfos) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
//            for (StayInfo stayInfo : stayInfos) {
//                String csvLine = convertToCsv(stayInfo);
//                writer.write(csvLine);
//                writer.newLine();
//                System.out.println("write ok");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
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


    public static Map<Integer, StayInfo> importStayInfo() {
        List<StayInfo> stayInfos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Map<Integer, StayInfo>  stayInfo = convertFromCsv(line);
                stayInfo.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stayInfos;
    }


//    private static String convertToCsv(Map<Integer, StayInfo> infoStorage) {
//        StringBuilder sb = new StringBuilder();
//        for (Map.Entry<Integer, StayInfo> entry : infoStorage.entrySet()) {
//            StayInfo stayInfo = entry.getValue();
//            sb.append(entry.getKey()).append(",");
//            sb.append(stayInfo.getId()).append(",");
//            sb.append(stayInfo.getGuest().getId()).append(",");
//            sb.append(stayInfo.getCheckInDate()).append(",");
//            sb.append(stayInfo.getCheckOutDate());
//            sb.append(System.lineSeparator());
//        }
//        return sb.toString();
//    }

    private static String convertToCsv(Integer numberRoomKey ,StayInfo stayInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(numberRoomKey).append(",");
        sb.append(stayInfo.getId()).append(",");
        sb.append(stayInfo.getGuest().getId()).append(",");
        sb.append(stayInfo.getGuest().getId()).append(",");
        sb.append(stayInfo.getCheckInDate()).append(",");
        sb.append(stayInfo.getCheckOutDate());
        return sb.toString();
    }


    private static Map<Integer, StayInfo> convertFromCsv(String csvLine) {
        String[] fields = csvLine.split(",");
        Integer numberRoomKey = Integer.parseInt(fields[0]);
        int idStayInfo = Integer.parseInt(fields[1]);
        int idGuest = Integer.parseInt(fields[2]);
        LocalDate checkInDate = LocalDate.parse(fields[3]);
        LocalDate checkOutDate = LocalDate.parse(fields[4]);


        // public StayInfo(int id, Guest guest, LocalDate checkInDate, LocalDate checkOutDate) {
        // LocalDate.parse(input)

       // Map<Integer, StayInfo>  stayInfoMap =
       // StayInfo stayInfo = new StayInfo(id, guestManager.getGuestById(idGuest), checkInDate, checkOutDate);
      //  return stayInfo;

        Map<Integer, StayInfo> stayInfoMap = new HashMap<>();
        stayInfoMap.put(numberRoomKey, new StayInfo(idStayInfo, guestManager.getGuestById(idGuest), checkInDate, checkOutDate));
        return stayInfoMap;
    }
}
