package com.tsystems.railwayservice.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

    @Column(name = "passenger_id")
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Passenger> passengers;

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

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
