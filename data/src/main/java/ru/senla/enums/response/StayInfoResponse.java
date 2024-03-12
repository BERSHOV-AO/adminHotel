package ru.senla.enums.response;

public enum StayInfoResponse {

    EXPORT_STAY_INFO_OK("Информация о прибывании успешно экспортирована!"),
    EXPORT_STAY_INFO_NOK("Информация о прибывании не экспортирована!"),
    ERROR_EXPORT_STAY_INFO("Ошибка экспорта информации о прибывании"),
    NO_INFORMATION_STAY_INFO("Нет доступной информации о прибывании!");

    private final String message;

    StayInfoResponse(String message) {
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
