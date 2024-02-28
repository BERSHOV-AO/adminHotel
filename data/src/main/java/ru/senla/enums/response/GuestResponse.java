package ru.senla.enums.response;

public enum GuestResponse {
    GUEST_ADDED("Гость добавлен"),
    GUEST_DELETED("Гость удален"),
    EXPORT_GUESTS_OK("Посетители успешно экспортированы!"),
    EXPORT_GUESTS_NOK("Посетители не экспортированы!"),
    IMPORT_GUESTS_OK("Посетители успешно импортированы!"),
    IMPORT_GUESTS_NOK("Посетители не импортированы!"),
    GUEST_CHECKED_INTO_THE_ROOM("Гость заселился в номер"),
    GUEST_NOT_ADDED("Гость не добавлен"),
    SERVICE_ADDED("Гостю добавлен сервис"),
    SERVICE_NOT_ADDED("Гостю не добавлен сервис"),
    NO_GUESTS_AVAILABLE("Нет доступных посетителей!"),
    GUEST_WITH_ID_DOES_NOT_EXIST("Посетителя с данным id не существует!"),
    GUEST_EVICTED_FROM_ROOM("Гость выселен из номера"),
    ERROR_PRINTING_GUEST_SERVICES("Ошибка печати услуг у гостя!");

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
