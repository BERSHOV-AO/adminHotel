package ru.senla.utils.serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ru.senla.entities.StayInfo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StayInfoSerializeDeserialize {

    private static final String FILE_PATH = "resources/data_serializer/stay_info.json";

    public static void serializeMapToJsonFile(Map<Integer, StayInfo> infoStorage) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Для красивого форматирования JSON

            File file = new File(FILE_PATH);
            objectMapper.writeValue(file, infoStorage);

            System.out.println("Информация о прибывании гостей в номерах сериализована и сохранена в " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Integer, StayInfo> deserializeJsonFileToMap() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            File file = new File(FILE_PATH);
            return objectMapper.readValue(file, new TypeReference<Map<Integer, StayInfo>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }
}
