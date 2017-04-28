package com.tsystems.railwayservice.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Passenger {

    @Id
    @GeneratedValue
    @Column
    private Long passengerId;

    @Column
    private String name;

    @Column
    private String surname;

    // date of birth in "dd.mm.yyyy" format
    @Column
    private String dateOfBirth;

    @Column(name = "train_id")
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Train> trains;

    public Set<Train> getTrains() {
        return trains;
    }

    public void setTrains(Set<Train> trains) {
        this.trains = trains;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long id) {
        this.passengerId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
