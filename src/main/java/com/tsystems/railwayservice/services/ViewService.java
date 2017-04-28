package com.tsystems.railwayservice.services;


import com.tsystems.railwayservice.entities.Passenger;
import com.tsystems.railwayservice.entities.Train;

import java.util.Set;

public interface ViewService {

    Set<Passenger> seeAllPassengersForTrain(long trainId);

    Set<Train> seeAllTrains();

}
