package com.tsystems.railwayservice.entities;

import javax.persistence.*;

@Entity
@Table
public class Train {

    @Id
    @GeneratedValue
    @Column
    private Long trainId;

    @Column
    private int numberOfSeats;

    @Column
    private String trainNumber;

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long id) {
        this.trainId = id;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }
}
