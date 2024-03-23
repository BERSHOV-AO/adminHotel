package ru.senla.utils.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ru.senla.entities.Guest;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GuestsSerializeDeserialize {
    private static final String FILE_PATH = "resources/data_serializer/guests.json";

    public static void serializeGuestsList(List<Guest> guestsList) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Для красивого форматирования JSON

            File file = new File(FILE_PATH);
            objectMapper.writeValue(file, guestsList);

            System.out.println("Список гостей сериализован и сохранен в " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Guest> deserializeGuestsList() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Guest> guestsList = null;

        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                guestsList = Arrays.asList(objectMapper.readValue(file, Guest[].class));
            } else {
                System.out.println(String.format("Файл %s не существует. Десериализация не выполнена.", FILE_PATH));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return guestsList;
    }
}
