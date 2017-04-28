package com.tsystems.railwayservice.entities;

import javax.persistence.*;

@Entity
@Table
public class Ticket {

    @Id
    @GeneratedValue
    @Column
    private Long ticketId;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @Column
    private int seatNumber;

    @ManyToOne
    @JoinColumn(name = "price_id")
    private Price price;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
