package ru.senla.enums;

public enum RoomResponse {
    NO_GUESTS_AVAILABLE("Нет доступных номеров!"),
    ROOM_WITH_ID_DOES_NOT_EXIST("Комнаты с данным id не существует!"),
    NUMBER_EXISTS_PLEASE_ENTER_ANOTHER_NUMBER("Номер существует, введите другой номер!"),
    ROOM_ADDED("Номер добавлен!"),
    ERROR_ADDING_ROOM("Ошибка добавления номера!"),
    ROOM_PRICE_CHANGE_OK("Цена номера изменена"),
    ROOM_PRICE_CHANGE_NOK("Номер не найден, цена номера не изменена"),
    ERROR_ROOM_PRICE_CHANGE("Ошибка изменения цены номера!");

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
