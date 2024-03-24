package ru.senla.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ConfigProperty {
    String configName() default "resources/config.properties"; // название файла конфигурации

    String propertyName() default "";

    ConfigType type() default ConfigType.STRING;
}
