package ru.senla.utils.csv_utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ExporterImporter<T> {
    public void export(List<T> data, String filePath, Function<T, String> converter) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (T object : data) {
                String csvLine = converter.apply(object);
                writer.write(csvLine);
                writer.newLine();
                System.out.println("write ok");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<T> importData(String filePath, Function<String, T> converter) {
        List<T> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                T object = converter.apply(line);
                data.add(object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
