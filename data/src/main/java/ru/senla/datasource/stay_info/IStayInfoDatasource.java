package ru.senla.datasource.stay_info;

import ru.senla.entities.StayInfo;

import java.util.Map;

public interface IStayInfoDatasource {

    public void addStayInfo(Integer roomNumber, StayInfo stayInfo);

    public void deleteStayInfo(Integer roomNumber);

    public Map<Integer, StayInfo> getInfoStorage();

    public void setStayInfo(Map<Integer, StayInfo> infoStorage);
}
