package ru.senla.utils.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ru.senla.entities.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ServicesSerializeDeserialize {

    private static final String FILE_PATH = "resources/data_serializer/services.json";

    public static void serializeServicesList(List<Service> servicesList) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Для красивого форматирования JSON

            File file = new File(FILE_PATH);
            objectMapper.writeValue(file, servicesList);

            System.out.println("Список сервисов(Услуг) сериализован и сохранен в " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Service> deserializeServicesList() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Service> servicesList = null;

        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                servicesList = Arrays.asList(objectMapper.readValue(file, Service[].class));
            } else {
                System.out.println(String.format("Файл %s не существует. Десериализация не выполнена.", FILE_PATH));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return servicesList;
    }
}
