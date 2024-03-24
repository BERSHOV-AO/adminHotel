package ru.senla.annotations;

import java.io.IOException;


public class Main {

    @ConfigProperty(propertyName = "name")
    private String name;

    @ConfigProperty(propertyName = "surname")
    private String surname;

    @ConfigProperty(propertyName = "age", type = ConfigType.INTEGER)
    private int age;

    public static void main(String[] args) throws IOException, IllegalAccessException {

        Main main = new Main();
        ConfigProcessor.processConfig(main);
        System.out.println(main.getName());
        System.out.println(main.getSurname());
        System.out.println(main.getAge());
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }
}
