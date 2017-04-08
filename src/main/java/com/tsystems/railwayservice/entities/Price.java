package com.tsystems.railwayservice.entities;

import javax.persistence.*;

@Entity
@Table
public class Price {

    //TYPE1 - плацкарт, TYPE2 - купе, TYPE3 - сидячий
    public enum TicketType {
        TYPE_1, TYPE_2, TYPE_3
        // TODO
    }

    @Id
    @GeneratedValue
    @Column
    private Long priceId;

    @ManyToOne
    @JoinColumn(name = "arrival_id")
    private ScheduleEntry arrival;

    @ManyToOne
    @JoinColumn(name = "departure_id")
    private ScheduleEntry departure;

    @Column
    private TicketType ticketType;

    @Column
    private Double price;

    public Long getPriceId() {
        return priceId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }

    public ScheduleEntry getArrival() {
        return arrival;
    }

    public void setArrival(ScheduleEntry arrival) {
        this.arrival = arrival;
    }

    public ScheduleEntry getDeparture() {
        return departure;
    }

    public void setDeparture(ScheduleEntry departure) {
        this.departure = departure;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
