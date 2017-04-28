package com.tsystems.railwayservice.services;

import com.tsystems.railwayservice.entities.ScheduleEntry;
import com.tsystems.railwayservice.entities.Station;
import com.tsystems.railwayservice.repositories.ScheduleDao;
import com.tsystems.railwayservice.repositories.StationDao;
import com.tsystems.railwayservice.repositories.TrainDao;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleDao scheduleDao;

    @Autowired
    private TrainDao trainDao;

    @Autowired
    private StationDao stationDao;

    @Override
    public Schedule getScheduleByStation(long stationId) {
        List<ScheduleEntry> scheduleEntries = scheduleDao.getByStation(stationId);

        Station station = stationDao.getById(stationId);
        List<Pair<ScheduleEntry, Station>> arrivalStations = scheduleEntries.stream()
                .map(scheduleEntry ->  Pair.with(scheduleEntry, trainDao.getArrivalStation(scheduleEntry.getTrain().getTrainId())))
                .collect(toList());
        List<Pair<ScheduleEntry, Station>> departureStations = scheduleEntries.stream()
                .map(scheduleEntry -> Pair.with(scheduleEntry, trainDao.getDepartureStation(scheduleEntry.getTrain().getTrainId())))
                .collect(toList());

        return new Schedule(station, arrivalStations, departureStations);
    }

}
