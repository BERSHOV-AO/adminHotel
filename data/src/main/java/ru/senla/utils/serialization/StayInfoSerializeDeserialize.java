package ru.senla.utils.serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.senla.entities.StayInfo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StayInfoSerializeDeserialize {

    private static final String FILE_PATH = "resources/data_serializer/services.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void serializeMapToJsonFile(Map<Integer, StayInfo> infoStorage) {
        try {
            File file = new File(FILE_PATH);
            objectMapper.writeValue(file, infoStorage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Integer, StayInfo> deserializeJsonFileToMap() {
        try {
            File file = new File(FILE_PATH);
            return objectMapper.readValue(file, new TypeReference<Map<Integer, StayInfo>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }
}
