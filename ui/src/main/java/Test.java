import room.AddRoomImpl;
import room.ChangeRoomPriceImpl;

public class Test {
    public static void main(String[] args) {

        AddRoomImpl addRoom = new AddRoomImpl();
        ChangeRoomPriceImpl changeRoomPrice = new ChangeRoomPriceImpl();


        addRoom.execute();
        changeRoomPrice.execute();
        changeRoomPrice.execute();

    }
}
