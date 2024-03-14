package ru.senla.utils.serialization;

import com.fasterxml.jackson.databind.SerializationFeature;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.senla.entities.Room;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class RoomsSerializeDeserialize {

    private static final String FILE_PATH = "resources/data_serializer/rooms.json";

    public static void serializeRoomsList(List<Room> roomsList) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Для красивого форматирования JSON

            File file = new File(FILE_PATH);
            objectMapper.writeValue(file, roomsList);

            System.out.println("Rooms list serialized and saved to " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Room> deserializeRoomsList() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Room> roomsList = null;

        try {
            File file = new File(FILE_PATH);
            roomsList = Arrays.asList(objectMapper.readValue(file, Room[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roomsList;
    }
}
