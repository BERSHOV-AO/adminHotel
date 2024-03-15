package ru.senla.utils.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataSerializer<T> {

    public void serializeData(List<T> dataList, String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Для красивого JSON
            File file = new File(filePath);
            objectMapper.writeValue(file, dataList);

            System.out.println("Данные сериализованы и сохранены в " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<T> deserializeData(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<T> dataList = null;

        try {
            File file = new File(filePath);
            if (file.exists()) {
                dataList = objectMapper.readValue(file, new TypeReference<List<T>>() {
                });
            } else {
                System.out.println(String.format("Файл %s не существует. Десериализация не выполнена.", filePath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }
}
