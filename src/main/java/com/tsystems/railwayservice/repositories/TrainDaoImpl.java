package com.tsystems.railwayservice.repositories;

import com.tsystems.railwayservice.entities.Station;
import com.tsystems.railwayservice.entities.Train;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

@Repository
public class TrainDaoImpl extends BaseDaoImpl<Train> implements TrainDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Station getArrivalStation(long trainId) {
        Query query = entityManager.createQuery(
                "select s from Station as s " +
                        "join ScheduleEntry on s.id = ScheduleEntry.station_id " +
                        "where ScheduleEntry.train_id = :trainId and ScheduleEntry.departureTime is null"
        )
                .setParameter("trainId", trainId);
        List<Station> resultList = query.getResultList();
        if (resultList.size() != 1) {
            throw new IllegalStateException("Train with " + trainId + " has not one arrival station!");
        }
        return resultList.get(0);
    }

    @Override
    public Station getDepartureStation(long trainId) {
        Query query = entityManager.createQuery(
                "select s from Station as s " +
                        "join ScheduleEntry on s.id = ScheduleEntry.station_id " +
                        "where ScheduleEntry.train_id = :trainId and ScheduleEntry.arrivalTime is null"
        )
                .setParameter("trainId", trainId);
        List<Station> resultList = query.getResultList();
        if (resultList.size() != 1) {
            throw new IllegalStateException("Train with " + trainId + " has not one departure station!");
        }
        return resultList.get(0);
    }
}
