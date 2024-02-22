package ru.senla.enums;

public enum GuestResponse {

    GUEST_ADDED("Гость добавлен"),
    GUEST_CHECKED_INTO_THE_ROOM("Гость заселился в номер"),
    GUEST_NOT_ADDED("Гость не добавлен"),
    SERVICE_ADDED("Гостю добавлен сервис"),
    SERVICE_NOT_ADDED("Гостю не добавлен сервис"),
    NO_GUESTS_AVAILABLE("Нет доступных посетителей!"),
    GUEST_WITH_ID_DOES_NOT_EXIST("Посетителя с данным id не существует!"),
    GUEST_EVICTED_FROM_ROOM("Гость выселен из номера");






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
