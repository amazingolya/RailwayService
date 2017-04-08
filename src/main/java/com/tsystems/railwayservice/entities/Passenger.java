package com.tsystems.railwayservice.entities;

import javax.persistence.*;

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
