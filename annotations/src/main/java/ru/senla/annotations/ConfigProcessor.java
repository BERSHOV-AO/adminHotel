package ru.senla.annotations;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class ConfigProcessor {
    public static void processConfig(Object object) throws IllegalAccessException, IOException {
        Class<?> clazz = object.getClass();
        Properties properties = new Properties();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ConfigProperty.class)) {
                ConfigProperty annotation = field.getAnnotation(ConfigProperty.class);
                properties.load(new FileReader(annotation.configName()));
                String propertyName = annotation.propertyName().isEmpty()
                        ? clazz.getSimpleName() + "." + field.getName()
                        : annotation.propertyName();
                String value = properties.getProperty(propertyName);
                ConfigType configType = annotation.type();

                if (value != null) {
                    field.setAccessible(true);
                    switch (configType) {
                        case INTEGER -> field.set(object, Integer.parseInt(value));
                        case DOUBLE -> field.set(object, Double.parseDouble(value));
                        case BOOLEAN -> field.set(object, Boolean.parseBoolean(value));
                        default -> field.set(object, value);
                    }
                }
            }
        }
    }
}
