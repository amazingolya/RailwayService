package com.tsystems.railwayservice.services;

import com.tsystems.railwayservice.entities.ScheduleEntry;
import com.tsystems.railwayservice.entities.Station;
import org.javatuples.Pair;

import java.util.List;

public interface ScheduleService {

    Schedule getScheduleByStation(long stationId);

    class Schedule {

        private final Station station;

        private final List<Pair<ScheduleEntry, Station>> entryAndDepartureStations;

        private final List<Pair<ScheduleEntry, Station>> entryAndArrivalStations;

        public Schedule(
                Station station,
                List<Pair<ScheduleEntry, Station>> entryAndDepartureStations,
                List<Pair<ScheduleEntry, Station>> entryAndArrivalStations
        ) {
            this.station = station;
            this.entryAndDepartureStations = entryAndDepartureStations;
            this.entryAndArrivalStations = entryAndArrivalStations;
        }

        public Station getStation() {
            return station;
        }

        public List<Pair<ScheduleEntry, Station>> getEntryAndDepartureStations() {
            return entryAndDepartureStations;
        }

        public List<Pair<ScheduleEntry, Station>> getEntryAndArrivalStations() {
            return entryAndArrivalStations;
        }
    }
}
