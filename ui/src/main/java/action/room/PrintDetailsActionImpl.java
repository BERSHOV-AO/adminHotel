package action.room;

import action.api.IAction;
import controllers.room.RoomManagerImpl;
import utils.ExistsEntity;
import utils.InputReader;

import java.util.Scanner;

public class PrintDetailsActionImpl implements IAction {
    @Override
    public void execute() {
        RoomManagerImpl roomManager = RoomManagerImpl.getInstance();
        if (roomManager.getAllRooms().size() == 0) {
            System.out.println("Нет доступных комнат!");
            return;
        }

        System.out.println("-------All Rooms-------");
        roomManager.getAllRooms().stream().forEach(System.out::println);

        try {
            int roomId = ExistsEntity.getExistsRoomID();
            System.out.println(roomManager.getRoomDetails(roomManager.getRoomById(roomId)));
        } catch (Exception e) {
            System.out.println("Нет возможности показать детали номера " + e.getMessage());
        }
    }
}
