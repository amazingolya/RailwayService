package com.tsystems.railwayservice.services;


import com.tsystems.railwayservice.entities.Station;
import com.tsystems.railwayservice.entities.Train;

public interface EditingService {

    void add(Train train);

    void add(Station station);
}
