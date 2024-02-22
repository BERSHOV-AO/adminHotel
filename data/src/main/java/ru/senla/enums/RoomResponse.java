package ru.senla.enums;

public enum RoomResponse {
//    GUEST_ADDED("Гость добавлен"),
//    GUEST_NOT_ADDED("Гость не добавлен"),
//    SERVICE_ADDED("Гостю добавлен сервис"),
//    SERVICE_NOT_ADDED("Гостю не добавлен сервис"),
    NO_GUESTS_AVAILABLE("Нет доступных номеров!"),
    ROOM_WITH_ID_DOES_NOT_EXIST("Комнаты с данным id не существует!");

    private final String message;

    RoomResponse(String message) {
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
