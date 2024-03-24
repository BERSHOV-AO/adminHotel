package ru.senla;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    @InjectDependency(ConfigurationType.HELLO)
    private  Hello hello;

    public Main() {
        Map<ConfigurationType, Object> configurationTypeObjectsMap = new HashMap<>();
        configurationTypeObjectsMap.put(ConfigurationType.HELLO, new Hello());
        DependencyInjector.injectDependencies(this, configurationTypeObjectsMap);
    }
    public static void main(String[] args) {

        Main main = new Main();
        main.hello.hello();

    }
}
