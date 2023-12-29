import guest.AddGuestImpl;
import guest.CheckInImpl;
import guest.CheckOutImpl;
import guest.PrintGuestsImpl;
import room.*;
import stayInfo.PrintStayInfoImpl;

public class Test {
    public static void main(String[] args) {

        //------------add-------------
        AddRoomImpl addRoom = new AddRoomImpl();
        AddGuestImpl addGuest = new AddGuestImpl();
        //------------print-------------
        PrintGuestsImpl printGuests = new PrintGuestsImpl();
        PrintRoomsImpl printRooms = new PrintRoomsImpl();

        CheckInImpl checkIn = new CheckInImpl();

        PrintStayInfoImpl printStayInfo = new PrintStayInfoImpl();

        CheckOutImpl checkOut = new CheckOutImpl();


        //======================================

        System.out.println("---add room---");
        addRoom.execute();
        System.out.println("---add room---");
        addRoom.execute();
        printRooms.execute();

        System.out.println("---add guest---");
        addGuest.execute();
        System.out.println("---add guest---");
        addGuest.execute();
     //   printGuests.execute();

       // printStayInfo.execute();
        checkIn.execute();
        checkIn.execute();

        checkOut.execute();

        printStayInfo.execute();


//        ChangeRoomPriceImpl changeRoomPrice = new ChangeRoomPriceImpl();
//        ChangeStatusImpl changeStatus = new ChangeStatusImpl();
//        PrintDetailsImpl printDetails = new PrintDetailsImpl();
//
//
//        addRoom.execute();
//        addRoom.execute();
//        changeRoomPrice.execute();
//        System.out.println("------------printDetails-----------");
//        printDetails.execute();
//        changeStatus.execute();
//        changeStatus.execute();

    }
}
