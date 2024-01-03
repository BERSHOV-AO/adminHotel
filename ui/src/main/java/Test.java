import guest.*;
import service.AddServiceImpl;
import service.PrintServiceImpl;

public class Test {
    public static void main(String[] args) {

        AddGuestImpl addGuest = new AddGuestImpl();
        PrintGuestsImpl printGuests = new PrintGuestsImpl();
        AddServiceImpl addService = new AddServiceImpl();
        PrintServiceImpl printService = new PrintServiceImpl();
        AddServicesToGuestImpl addServicesToGuest = new AddServicesToGuestImpl();
        DeleteGuestImpl deleteGuest = new DeleteGuestImpl();
        PrintServicesOneGuestImpl printServicesOneGuest = new PrintServicesOneGuestImpl();

        /**
         * *****************************************************************************
         */

        addGuest.execute();
        addService.execute();
        addService.execute();
        addService.execute();
        addService.execute();

        addServicesToGuest.execute();
        addServicesToGuest.execute();
        addServicesToGuest.execute();

        printServicesOneGuest.execute();



//        addGuest.execute();
//        addGuest.execute();
//        addGuest.execute();
//        addGuest.execute();
//        deleteGuest.execute();
//        printGuests.execute();



//        addGuest.execute();
//        addGuest.execute();
//        addService.execute();
//        addService.execute();
//        printService.execute();
//        addServicesToGuest.execute();
//        addServicesToGuest.execute();
//        addServicesToGuest.execute();
//        printGuests.execute();




//        AddServiceImpl addService = new AddServiceImpl();
//        PrintServiceImpl printService = new PrintServiceImpl();
//
//        addService.execute();
//        addService.execute();
//        printService.execute();

//        AddGuestImpl addGuest = new AddGuestImpl();
//        AddServicesToGuestImpl  addServicesToGuest = new AddServicesToGuestImpl();
//        PrintGuestsImpl printGuests = new PrintGuestsImpl();

        //----------------------------------------------------------------------
//        addGuest.execute();
//        addGuest.execute();
        //  printGuests.execute();

        // --------------addServicesToGuest----------------
//        addServicesToGuest.execute();
//
//        printGuests.execute();


//        //------------add-------------
//        AddRoomImpl addRoom = new AddRoomImpl();
//        AddGuestImpl addGuest = new AddGuestImpl();
//        //------------print-------------
//        PrintGuestsImpl printGuests = new PrintGuestsImpl();
//        PrintRoomsImpl printRooms = new PrintRoomsImpl();
//
//        CheckInImpl checkIn = new CheckInImpl();
//
//        PrintStayInfoImpl printStayInfo = new PrintStayInfoImpl();
//
//        CheckOutImpl checkOut = new CheckOutImpl();
//
//
//        //======================================
//
//        System.out.println("---add room---");
//        addRoom.execute();
//        System.out.println("---add room---");
//        addRoom.execute();
//        printRooms.execute();
//
//        System.out.println("---add guest---");
//        addGuest.execute();
//        System.out.println("---add guest---");
//        addGuest.execute();
//        //   printGuests.execute();
//
//        // printStayInfo.execute();
//        checkIn.execute();
//        checkIn.execute();
//        checkOut.execute();
//        printStayInfo.execute();


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
