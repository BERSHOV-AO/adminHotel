package ru.senla.utils.serialization;

import com.fasterxml.jackson.databind.SerializationFeature;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.senla.entities.Room;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class RoomsSerializeDeserialize {

    private static final String FILE_PATH = "resources/data_serializer/rooms.json";


    // вариант с дженериком
//    public static void serializeRoomsList(List<Room> roomsList) {
//        DataSerializer<Room> roomDataSerializer = new DataSerializer<>();
//        roomDataSerializer.serializeData(roomsList, FILE_PATH);
//    }
//
//    public static List<Room> deserializeRoomsList() {
//        DataSerializer<Room> roomDataSerializer = new DataSerializer<>();
//        List<Room> deserializedRoomsList = roomDataSerializer.deserializeData(FILE_PATH);
//        return deserializedRoomsList;
//    }


    public static void serializeRoomsList(List<Room> roomsList) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Для красивого форматирования JSON

            File file = new File(FILE_PATH);
            objectMapper.writeValue(file, roomsList);

            System.out.println("Список номеров сериализован и сохранен в " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Room> deserializeRoomsList() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Room> roomsList = null;

        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                roomsList = Arrays.asList(objectMapper.readValue(file, Room[].class));
            } else {
                System.out.println(String.format("Файл %s не существует. Десериализация не выполнена.", FILE_PATH));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roomsList;
    }
}
