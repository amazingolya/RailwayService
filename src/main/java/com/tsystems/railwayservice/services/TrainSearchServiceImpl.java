package com.tsystems.railwayservice.services;


import com.tsystems.railwayservice.entities.Station;
import com.tsystems.railwayservice.entities.Train;
import com.tsystems.railwayservice.repositories.ScheduleDao;
import com.tsystems.railwayservice.repositories.StationDao;
import com.tsystems.railwayservice.repositories.TrainDao;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TrainSearchServiceImpl implements TrainSearchService {

    @Autowired
    private ScheduleDao scheduleDao;

    @Autowired
    private TrainDao trainDao;

    @Autowired
    private StationDao stationDao;

    @Override
    public List<TrainItem> getTrainsByRouteAndTime(long departureStationId, long arrivalStationId, long departureDate, long arrivalDate) {
        List<Map> schedule = scheduleDao.getScheduleByRouteAndTime(departureStationId, arrivalStationId, departureDate, arrivalDate);
        List<TrainItem> listOfTrains = new ArrayList<>();
        for (Map scheduleLines: schedule) {
            Train train = trainDao.getById((Long) scheduleLines.get("departure.train_Id"));
            Pair<Station, Long> departureStationAndTime = Pair.with(stationDao.getById(departureStationId), (Long) scheduleLines.get("departure.departure_time"));
            Pair<Station, Long> arrivalStationAndTime = Pair.with(stationDao.getById(arrivalStationId), (Long) scheduleLines.get("arrival.arrival_time"));
            listOfTrains.add(new TrainItem(train, departureStationAndTime, arrivalStationAndTime));
        }
        return listOfTrains;
    }
}
