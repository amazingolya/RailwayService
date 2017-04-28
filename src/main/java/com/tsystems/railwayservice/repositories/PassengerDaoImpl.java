package com.tsystems.railwayservice.repositories;

import com.tsystems.railwayservice.entities.Passenger;
import com.tsystems.railwayservice.entities.Train;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PassengerDaoImpl extends BaseDaoImpl<Passenger> implements PassengerDao {

    @PersistenceContext
    private EntityManager entityManager;

    //TODO
    @Override
    public boolean checkPassengerOnTrain(String name, String surname, String dateOfBirth, long trainId) {
        Query query = entityManager.createQuery("SELECT passenger_id FROM Passenger " +
                "JOIN Passenger_Train ON Passenger_Train.passenger_id = passenger_id " +
                "WHERE Passenger.name = :name" +
                " AND Passenger.surname = :surname AND Passenger.date_of_birth = :dateOfBirth " +
                "AND Passenger_Train.train_id = :trainId ")
                .setParameter("name", name)
                .setParameter("surname", surname)
                .setParameter("dateOfBirth", dateOfBirth)
                .setParameter("trainId", trainId);

        return query.getResultList() == null;
    }

    @Override
    public Passenger checkPassenger(String name, String surname, String dateOfBirth) {
        Query query = entityManager.createQuery("SELECT passenger_id FROM Passenger "  +
                "WHERE Passenger.name = :name" +
                " AND Passenger.surname = :surname " +
                "AND Passenger.date_of_birth = :dateOfBirth ")
                .setParameter("name", name)
                .setParameter("surname", surname)
                .setParameter("dateOfBirth", dateOfBirth);

        Passenger passenger = (Passenger) query.getSingleResult();
        if (passenger != null) {
            return passenger;
        }
        return null;
    }

}
