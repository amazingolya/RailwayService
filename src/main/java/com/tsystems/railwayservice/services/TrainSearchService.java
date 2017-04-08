package com.tsystems.railwayservice.services;


import com.tsystems.railwayservice.entities.Station;
import com.tsystems.railwayservice.entities.Train;
import org.javatuples.Pair;


import java.util.List;

public interface TrainSearchService {

    List<TrainItem> getTrainsByRouteAndTime(long departureStationId, long arrivalStationId, long departureDate, long arrivalDate);

    class TrainItem {

        private final Train train;

        private final Pair<Station, Long> departureStationAndTime;

        private final Pair<Station, Long> arrivalStationAndTime;

        public TrainItem(Train train,
                         Pair<Station, Long> departureStationAndTime,
                         Pair<Station, Long> arrivalStationAndTime) {
            this.train = train;
            this.departureStationAndTime = departureStationAndTime;
            this.arrivalStationAndTime = arrivalStationAndTime;
        }

        public Train getTrain() {
            return train;
        }

        public Pair<Station, Long> getDepartureStationAndTime() {
            return departureStationAndTime;
        }

        public Pair<Station, Long> getArrivalStationAndTime() {
            return arrivalStationAndTime;
        }
    }

}
