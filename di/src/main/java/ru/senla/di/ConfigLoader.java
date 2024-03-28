package ru.senla.di;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigLoader {
    public static Map<Class, Class> loadConfig(String configFilePath) {
        Map<Class, Class> ifc2ImplClass = new HashMap<>();
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(configFilePath)) {
            properties.load(fis);
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                String ifcClassName = entry.getKey().toString();
                String implClassName = entry.getValue().toString();

                try {
                    Class<?> ifcClass = Class.forName(ifcClassName);
                    Class<?> implClass = Class.forName(implClassName);

                    ifc2ImplClass.put(ifcClass, implClass);
                } catch (ClassNotFoundException e) {
                    System.err.println("Error loading class: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading config file: " + e.getMessage());
        }
        return ifc2ImplClass;
    }
}
