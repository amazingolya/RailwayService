package com.tsystems.railwayservice.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Train {

    @Id
    @GeneratedValue
    @Column
    private Long trainId;

    @OneToMany
    @JoinColumn(name = "trainId")
    private List<TrainSeats> trainSeats;

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

    public List<TrainSeats> getTrainSeats() {
        return trainSeats;
    }

    public void setTrainSeats(List<TrainSeats> trainSeats) {
        this.trainSeats = trainSeats;
    }
}
