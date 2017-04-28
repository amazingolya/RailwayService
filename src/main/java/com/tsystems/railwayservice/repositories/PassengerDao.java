package com.tsystems.railwayservice.repositories;


import com.tsystems.railwayservice.entities.Passenger;
import com.tsystems.railwayservice.entities.Train;

import java.util.List;

public interface PassengerDao extends BaseDao<Passenger> {

    boolean checkPassengerOnTrain(String name, String surname, String dateOfBirth, long trainId);

    Passenger checkPassenger(String name, String surname, String dateOfBirth);
}
