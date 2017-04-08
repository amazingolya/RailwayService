package com.tsystems.railwayservice.repositories;

import com.tsystems.railwayservice.entities.Station;
import com.tsystems.railwayservice.entities.Train;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TrainDaoImpl implements TrainDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Train getById(long id) {
        return entityManager.find(Train.class, id);
    }

    @Override
    public List<Train> getAll() {
        return null;
    }

    @Override
    public void update(Train train) {
        entityManager.merge(train);
    }

    @Override
    public void add(Train train) {
        entityManager.persist(train);
    }

    @Override
    public void delete(Train train) {
        entityManager.remove(train);
    }

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
