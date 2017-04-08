package com.tsystems.railwayservice.repositories;


import com.tsystems.railwayservice.entities.Station;
import com.tsystems.railwayservice.entities.Train;

public interface TrainDao extends BaseDao<Train> {

    Station getArrivalStation(long trainId);

    Station getDepartureStation(long trainId);
}
