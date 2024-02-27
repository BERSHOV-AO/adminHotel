package ru.senla.enums.response;

public enum RoomResponse {
    NO_ROOMS_AVAILABLE("Нет доступных номеров!"),
    ROOM_WITH_ID_DOES_NOT_EXIST("Комнаты с данным id не существует!"),
    NUMBER_EXISTS_PLEASE_ENTER_ANOTHER_NUMBER("Номер существует, введите другой номер!"),
    ROOM_ADDED("Номер добавлен!"),
    ERROR_ADDING_ROOM("Ошибка добавления номера!"),
    ROOM_PRICE_CHANGE_OK("Цена номера изменена"),
    ROOM_PRICE_CHANGE_NOK("Номер не найден, цена номера не изменена"),
    ERROR_ROOM_PRICE_CHANGE("Ошибка изменения цены номера!"),
    ROOM_STATUS_CHANGED_OK("Статус номера изменен!"),
    ERROR_CHANGING_ROOM_STATUS("Ошибка изменения статуса номера!"),
    EXPORT_ROOMS_OK("Номера успешно экспортированы!"),
    EXPORT_ROOMS_NOK("Номера не экспортированы!"),
    ERROR_EXPORT_ROOMS("Ошибка экспорта номеров"),
    IMPORT_ROOMS_OK("Номера успешно импортированы!"),
    IMPORT_ROOMS_NOK("Номера не импортированы!"),
    ERROR_IMPORT_ROOMS("Ошибка импорта номеров!"),
    ERROR_PRINT_ROOM_INFO("Ошибка печати информации о номере!");

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
