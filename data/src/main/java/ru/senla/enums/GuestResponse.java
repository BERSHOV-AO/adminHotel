package ru.senla.enums;

public enum GuestResponse {

    GUEST_ADDED("Гость добавлен"),
    GUEST_NOT_ADDED("Гость не добавлен"),
    SERVICE_ADDED("Гостю добавлен сервис"),
    SERVICE_NOT_ADDED("Гостю не добавлен сервис");

    private final String message;

    GuestResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
