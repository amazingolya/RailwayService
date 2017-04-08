package com.tsystems.railwayservice.entities;

import javax.persistence.*;

@Entity
@Table
public class Train {

    @Id
    @GeneratedValue
    @Column
    private Long trainId;

    @OneToMany
    @JoinColumn(name = "number_of_seats")
    private TrainSeats trainSeats;

    @Column
    private String trainNumber;

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long id) {
        this.trainId = id;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public TrainSeats getTrainSeats() {
        return trainSeats;
    }

    public void setTrainSeats(TrainSeats trainSeats) {
        this.trainSeats = trainSeats;
    }
}
