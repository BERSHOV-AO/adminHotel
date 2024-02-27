package ru.senla.enums.response;

public enum StayInfoResponse {

    //    GUEST_ADDED("Гость добавлен"),
//    GUEST_NOT_ADDED("Гость не добавлен"),
//    SERVICE_ADDED("Гостю добавлен сервис"),
//    SERVICE_NOT_ADDED("Гостю не добавлен сервис"),
    NO_INFORMATION_STAY_INFO("Нет доступной информации о проживании!");

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
