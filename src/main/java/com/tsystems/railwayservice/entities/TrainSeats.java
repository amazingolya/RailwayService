package com.tsystems.railwayservice.entities;

import javax.persistence.*;

@Entity
@Table
public class TrainSeats {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private int numberOfSeats;

    @Column
    private Long trainId;

    @ManyToOne
    @JoinColumn(name = "ticket_type")
    private Price price;

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
