package utils;

import java.io.File;
import java.io.IOException;


public class FileCreation {

    // String filePath = "resources/rooms.csv";

    public static void createFileIfNotExists(String filePath) {

        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.out.println("Файл успешно создан");
            } else {
                System.out.println("Файл уже существует");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }
    }
}
