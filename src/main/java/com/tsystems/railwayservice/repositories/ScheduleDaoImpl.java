package com.tsystems.railwayservice.repositories;

import com.tsystems.railwayservice.entities.ScheduleEntry;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Repository
public class ScheduleDaoImpl extends BaseDaoImpl<ScheduleEntry> implements ScheduleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ScheduleEntry> getByStation(long stationId) {
        Query query = entityManager
                .createQuery("SELECT s FROM ScheduleEntry AS s WHERE s.station_id = :stationId")
                .setParameter("stationId", stationId);
        List<ScheduleEntry> resultList = query.getResultList();
        return resultList;
    }

    @Override
    public List<Map> getScheduleByRouteAndTime(
            long departureStationId, long arrivalStationId, long departureDate, long arrivalDate) {
        Query query = entityManager
                .createQuery("FROM (FROM ScheduleEntry WHERE " +
                        "departure_time >= :departureDate AND " +
                        "station_id = :departureStationId) AS departure JOIN (FROM ScheduleEntry WHERE " +
                        "arrival_time >= :arrivalDate AND " +
                        "station_id = :arrivalStationId) AS arrival ON departure.train_Id = arrival.train_Id AND " +
                        "departure.direction = arrival.direction")
                .setParameter("departureDate", departureDate)
                .setParameter("arrivalDate", arrivalDate)
                .setParameter("arrivalStationId", arrivalStationId)
                .setParameter("departureStationId", departureStationId);

        return query.getResultList();
    }
}

