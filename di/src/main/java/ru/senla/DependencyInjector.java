package ru.senla;

import java.lang.reflect.Field;
import java.util.Map;

public class DependencyInjector {
    public static void injectDependencies(Object object, Map<ConfigurationType, Object> configurations) {

        Field[] fields = object.getClass().getDeclaredFields();
        for(Field field : fields) {
            if (field.isAnnotationPresent(InjectDependency.class)) {
                InjectDependency annotation = field.getAnnotation(InjectDependency.class); {
                  ConfigurationType type = annotation.value();
                  Object dependency = configurations.get(type);
                  if (dependency != null) {
                      field.setAccessible(true);
                      try {
                          field.set(object, dependency);
                      } catch (IllegalAccessException e) {
                          throw new RuntimeException(e);
                      }
                  }
                }
            }
        }

    }
}
