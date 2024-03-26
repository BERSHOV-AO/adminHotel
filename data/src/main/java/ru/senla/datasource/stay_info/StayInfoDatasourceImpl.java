package ru.senla.datasource.stay_info;

import ru.senla.di_factory.Singleton;
import ru.senla.entities.StayInfo;

import java.util.LinkedHashMap;
import java.util.Map;
@Singleton
public class StayInfoDatasourceImpl implements IStayInfoDatasource {
    private Map<Integer, StayInfo> infoStorage = new LinkedHashMap<>();

    private static StayInfoDatasourceImpl instance;

    public StayInfoDatasourceImpl() {
    }

    public static StayInfoDatasourceImpl getInstance() {
        if (instance == null) {
            instance = new StayInfoDatasourceImpl();
        }
        return instance;
    }

    @Override
    public void addStayInfo(Integer roomNumber, StayInfo stayInfo) {
        infoStorage.put(roomNumber, stayInfo);
    }

    @Override
    public void deleteStayInfo(Integer roomNumber) {
        infoStorage.remove(roomNumber);
    }

    @Override
    public Map<Integer, StayInfo> getInfoStorage() {
        return infoStorage;
    }

    @Override
    public void setStayInfo(Map<Integer, StayInfo> infoStorage) {
        this.infoStorage = infoStorage;
    }
}
