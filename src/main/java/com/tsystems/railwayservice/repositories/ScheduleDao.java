package com.tsystems.railwayservice.repositories;

import com.tsystems.railwayservice.entities.ScheduleEntry;

import java.util.List;

public interface ScheduleDao extends BaseDao<ScheduleEntry> {

    List<ScheduleEntry> getByStation(long stationId);
}
