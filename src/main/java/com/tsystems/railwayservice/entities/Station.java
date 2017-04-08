package com.tsystems.railwayservice.entities;

import javax.persistence.*;

@Entity
@Table
public class Station {

    @Id
    @GeneratedValue
    @Column
    private Long stationId;

    @Column
    private String name;

    //time zone in "Europe/Oslo" format
    @Column
    private String timeZone;

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long id) {
        this.stationId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
