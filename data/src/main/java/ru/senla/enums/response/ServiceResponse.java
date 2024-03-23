package ru.senla.enums.response;

public enum ServiceResponse {
    NO_SERVICES_AVAILABLE("Нет доступных сервисов!"),
    SERVICE_ADDED("Сервис добавлен!"),
    ERROR_SERVICE_ADDED("Ошибка добавления услуги(сервиса)!"),
    SERVICE_DELETED("Сервис удален!"),
    SERVICE_PRICE_CHANGE_OK("Цена услуги(сервиса) изменена!"),
    ERROR_SERVICE_PRICE_CHANGE_NOK("Ошибка, цена услуги(сервиса) не изменена!"),
    SERVICE_WITH_ID_DOES_NOT_EXIST("Услуги(сервиса) с данным id не существует!"),
    DELETED_SERVICE("Услуга(Сервис) удалена!"),
    ERROR_DELETED_SERVICE("Ошибка удаления услуги(сервиса)!"),
    EXPORT_SERVICES_OK("Услуги(сервисы) успешно экспортированы!"),
    EXPORT_SERVICES_NOK("Услуги(сервисы) не экспортированы!"),
    ERROR_EXPORT_SERVICES("Ошибка экспорта услуг(сервисов)"),
    IMPORT_SERVICES_OK("Услуги(сервисы) успешно импортированы!"),
    IMPORT_SERVICES_NOK("Услуги(сервисы) не импортированы!"),
    ERROR_IMPORT_SERVICES("Ошибка импорта услуг(сервисов)!");

    private final String message;

    ServiceResponse(String message) {
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
