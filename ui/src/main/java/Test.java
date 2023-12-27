import room.AddRoomImpl;
import room.ChangeRoomPriceImpl;
import room.ChangeStatusImpl;
import room.PrintDetailsImpl;

public class Test {
    public static void main(String[] args) {

        AddRoomImpl addRoom = new AddRoomImpl();
        ChangeRoomPriceImpl changeRoomPrice = new ChangeRoomPriceImpl();
        ChangeStatusImpl changeStatus = new ChangeStatusImpl();
        PrintDetailsImpl printDetails = new PrintDetailsImpl();


        addRoom.execute();
        addRoom.execute();
        changeRoomPrice.execute();
        System.out.println("------------printDetails-----------");
        printDetails.execute();
//        changeStatus.execute();
//        changeStatus.execute();

    }
}
