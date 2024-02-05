package csv_utils;

import controllers.guest.GuestManagerImpl;
import models.Guest;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class GuestImporterExporter {

    private static GuestManagerImpl guestManager = GuestManagerImpl.getInstance();

    private static final String FILE_PATH = "resources/guest.csv";

    public static void exportGuest(List<Guest> guests) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Guest guest : guests) {
                String csvLine = convertToCsv(guest);
                writer.write(csvLine);
                writer.newLine();
                System.out.println("write ok");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Guest> importGuests() {
        List<Guest> guests = guestManager.getAllGuests();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Guest guest = convertFromCsv(line);
                Iterator<Guest> iterator = guests.iterator();
                while (iterator.hasNext()) {
                    Guest tempGuest = iterator.next();
                    if (tempGuest.getId() == guest.getId()) {
                        iterator.remove();
                        break;
                    }
                }
                guests.add(guest);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return guests;
    }

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
}

