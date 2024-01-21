package controllers.service;

import controllers.room_history.RoomHistoryManagerImpl;
import enums.RoomHistoryStatus;
import enums.RoomStatus;
import enums.ServiceType;
import models.*;
import storages.service.ServicesStorageImpl;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceManagerImpl implements ServiceManager {

    private static ServiceManagerImpl instance;

    private ServiceManagerImpl() {
    }

    public static ServiceManagerImpl getInstance() {
        if (instance == null) {
            instance = new ServiceManagerImpl();
        }
        return instance;
    }

    @Override
    public void addService(Service service) {
        ServicesStorageImpl.getInstance().addService(service);
    }

    @Override
    public List<Service> getAllServices() {
        return ServicesStorageImpl.getInstance().getServices();
    }

    @Override
    public void changeServicePrice(Service service, double price) {
        ServicesStorageImpl.getInstance().getServices().stream()
                .filter(r -> r.getServiceType() == service.getServiceType())
                .findFirst()
                .ifPresent(r -> {
                    r.setPrice(price);
                });
    }

    @Override
    public List<Service> getListSortByPrice() {
        return ServicesStorageImpl.getInstance().getServices().stream()
                .sorted(Comparator.comparingDouble(Service::getPrice))
                .collect(Collectors.toList());
    }

    public List<Service> getListServicesSortByPriceOneGuest(List<Service> serviceList) {

        System.out.println("serviceList: " + serviceList);
        return serviceList.stream()
                .sorted(Comparator.comparingDouble(Service::getPrice))
                .collect(Collectors.toList());
    }


    @Override
    public List<Service> getListSortBySection() {
        return ServicesStorageImpl.getInstance().getServices().stream()
                .sorted(Comparator.comparing(service -> service.getServiceType().name()))
                .collect(Collectors.toList());
    }

    @Override
    public Service getServiceByType(ServiceType serviceType) {
        return ServicesStorageImpl.getInstance().getServices().stream()
                .filter(service -> service.getServiceType().equals(serviceType))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteService(Service service) {
        ServicesStorageImpl.getInstance().deleteService(service);
    }

    //-------------------------------------------------------------------------------------------------------

//    @Override
//    public void showServicesSortByPrice() {
//        serviceManagerImpl.sortByPrice().stream().forEach(System.out::println);
//    }

//    @Override
//    public void showServicesSortBySection() {
//        serviceManagerImpl.sortBySection().stream().forEach(System.out::println);
//    }

//    @Override
//    public Service getServiceByType(ServiceType serviceType) {
//        return serviceManagerImpl.getServiceByType(serviceType);
//    }

//    @Override
//    public void deleteService(Service service) {
//        serviceManagerImpl.deleteService(service);
//    }

//    @Override
//    public void showServiceSortByPriceOneGuest(List<Service> serviceList) {
//        serviceManagerImpl.sortByPriceOneGuest(serviceList).stream().forEach(System.out::println);
//    }

//    @Override
//    public void createService(Service service) {
//        serviceManagerImpl.addService(service);
//    }

//    @Override
//    public void changeServiceOnPrice(Service service, double price) {
//        serviceManagerImpl.changeServicePrice(service, price);
//    }

//    @Override
//    public void printAllService() {
//        serviceManagerImpl.printService();
//    }

//    @Override
//    public void showStayInfo() {
//        stayInfoManagerImpl.printStayInfo();
//    }

//    @Override
//    public void checkInGuestInRoom(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
//
//        if (room.getStatus() == RoomStatus.EMPTY) {
//            RoomHistory newRoomHistory = new RoomHistory();
//
//            newRoomHistory.setGuest(guest);
//            newRoomHistory.setRoom(room);
//            newRoomHistory.setCheckInDate(checkInDate);
//            newRoomHistory.setCheckOutDate(checkOutDate);
//            newRoomHistory.setStatus(RoomHistoryStatus.CHECKIN);
//
//            stayInfoManagerImpl.addStayInfo(room.getRoomNumber(), new StayInfo(guest, checkInDate, checkOutDate));
//            roomHistoryManagerImpl.addHistory(newRoomHistory);
//            roomManagerImpl.changeRoomStatus(room, RoomStatus.OCCUPIED);
//        } else {
//            System.out.println("Заселить в комнату " + room.getRoomNumber() + " не представляется возможным. "
//                    + "Статус комнаты = " + room.getStatus());
//        }
//    }
//
//    @Override
//    public void checkOutGuestFromRoom(Guest guest, Room room) {
//        if (stayInfoManagerImpl.searchGuestInTheRoom(guest, room)) {
//            if (room.getStatus() == RoomStatus.OCCUPIED) {
//                stayInfoManagerImpl.deleteStayInfo(room.getRoomNumber());
//                roomManagerImpl.changeRoomStatus(room, RoomStatus.EMPTY);
//            }
//        } else {
//            System.out.println("В комнате " + room.getRoomNumber() + " нет посетителей");
//        }
//    }

}
