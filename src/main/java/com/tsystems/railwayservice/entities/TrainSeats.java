package com.tsystems.railwayservice.entities;

import javax.persistence.*;

@Entity
@Table
public class TrainSeats {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    @ManyToOne
    @JoinColumn(name = "ticket_type")
    private Price price;

    @ManyToOne
    @JoinColumn(name = "number_of_seats")
    private Train train2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Train getTrain2() {
        return train2;
    }

    public void setTrain2(Train train2) {
        this.train2 = train2;
    }
}
