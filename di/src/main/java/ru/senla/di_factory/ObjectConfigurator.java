package ru.senla.di_factory;

// должен только настраивать объект
public interface ObjectConfigurator {
    void configure(Object t, ApplicationContext context);

}
