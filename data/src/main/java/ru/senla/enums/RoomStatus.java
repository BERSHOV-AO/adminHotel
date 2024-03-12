package ru.senla.enums;

public enum RoomStatus {
    EMPTY(1),
    OCCUPIED(2),
    UNDER_REPAIR(3),
    SERVICE(4);

    private int id;

    RoomStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static RoomStatus integerRoomStatus(Integer input) {
        RoomStatus roomStatus = null;

        for (RoomStatus status : RoomStatus.values()) {
            if (status.getId() == input) {
                roomStatus = status;
                break;
            }
        }
        return roomStatus;
    }
}