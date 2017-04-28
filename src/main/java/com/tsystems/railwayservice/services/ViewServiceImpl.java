package com.tsystems.railwayservice.services;

import com.tsystems.railwayservice.entities.Passenger;
import com.tsystems.railwayservice.entities.Train;
import com.tsystems.railwayservice.repositories.TrainDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class ViewServiceImpl implements ViewService {

    @Autowired
    private TrainDao trainDao;

    public Set<Passenger> seeAllPassengersForTrain(long trainId) {
        Train train = trainDao.getById(trainId);
        return train.getPassengers();
    }

    @Override
    public Set<Train> seeAllTrains() {
        return trainDao.getAll();
    }

}
