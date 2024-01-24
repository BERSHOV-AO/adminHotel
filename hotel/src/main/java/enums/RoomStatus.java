package enums;

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

        if (roomStatus == null) {
            System.out.println("Неправильный ввод. Пожалуйста, " +
                    "введите цифру статуса номера: 1 = EMPTY, 2 = OCCUPIED, 3 = UNDER_REPAIR, 4 = SERVICE");
        }
        return roomStatus;
    }


}