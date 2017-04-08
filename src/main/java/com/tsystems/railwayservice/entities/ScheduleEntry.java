package com.tsystems.railwayservice.entities;

import javax.persistence.*;

@Entity
@Table
public class ScheduleEntry {

    public static enum Direction {
        FORWARD, BACKWARD
    }

    @Id
    @GeneratedValue
    @Column
    private Long scheduleId;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    // null if final station
    @Column
    private Long departureTime;

    // null if start station
    @Column
    private Long arrivalTime;

    @Column
    private Direction direction;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Long getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Long departureTime) {
        this.departureTime = departureTime;
    }

    public Long getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
