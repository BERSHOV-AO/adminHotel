package ru.senla.di;

// должен только настраивать объект
public interface ObjectConfigurator {
    void configure(Object t, ApplicationContext context);

}
