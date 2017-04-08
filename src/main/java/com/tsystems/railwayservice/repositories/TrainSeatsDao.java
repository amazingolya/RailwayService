package com.tsystems.railwayservice.repositories;


import com.tsystems.railwayservice.entities.Passenger;
import com.tsystems.railwayservice.entities.TrainSeats;

public interface TrainSeatsDao extends BaseDao<TrainSeats> {

    boolean checkTime(Long time);

    boolean checkPassengerDuplicates(Passenger passenger);

}
