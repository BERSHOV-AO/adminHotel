package ru.senla.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final String CONFIG_FILE = "properties/resources/config.properties";
    private Properties properties;
    private static ConfigReader reader;

    public ConfigReader() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(CONFIG_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isRoomStatusChangeEnabled() {
        // включить изменение статуса комнаты
        return Boolean.parseBoolean(properties.getProperty("enable_room_status_change"));
    }

    public int getHistoryRecordsCount() {
        // количество записей в истории
        return Integer.parseInt(properties.getProperty("history_records_count"));
    }

    public static ConfigReader getReader() {
        if (reader == null) {
            return new ConfigReader();
        }
        return reader;
    }
}
