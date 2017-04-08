package com.tsystems.railwayservice.repositories;

import com.tsystems.railwayservice.entities.ScheduleEntry;

import java.util.List;
import java.util.Map;

public interface ScheduleDao extends BaseDao<ScheduleEntry> {

    List<ScheduleEntry> getByStation(long stationId);

    List<Map> getScheduleByRouteAndTime(long departureStationId, long arrivalStationId, long departureDate, long arrivalDate);

}
