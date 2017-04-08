package com.tsystems.railwayservice.repositories;

import com.tsystems.railwayservice.entities.ScheduleEntry;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class ScheduleDaoImpl extends BaseDaoImpl<ScheduleEntry> implements ScheduleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ScheduleEntry> getByStation(long stationId) {
        Query query = entityManager
                .createQuery("select s from ScheduleEntry as s where s.station_id = :stationId")
                .setParameter("stationId", stationId);
        List<ScheduleEntry> resultList = query.getResultList();
        return resultList;
    }
}

