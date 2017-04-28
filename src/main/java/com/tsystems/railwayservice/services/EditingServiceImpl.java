package com.tsystems.railwayservice.services;


import com.tsystems.railwayservice.entities.Station;
import com.tsystems.railwayservice.entities.Train;
import com.tsystems.railwayservice.repositories.StationDao;
import com.tsystems.railwayservice.repositories.TrainDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EditingServiceImpl implements EditingService {

    @Autowired
    private TrainDao trainDao;

    @Autowired
    private StationDao stationDao;

    @Override
    public void add(Train train) {
        trainDao.add(train);
    }

    @Override
    public void add(Station station) {
        stationDao.add(station);
    }
}
