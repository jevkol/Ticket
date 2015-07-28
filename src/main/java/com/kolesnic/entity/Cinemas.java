package com.kolesnic.entity;

import javax.persistence.*;

@Entity
@Table(name = "CINEMAS")
public class Cinemas{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "Name", unique = true, length = 30, nullable = false)
    private String name;

    @Column(name = "ADRES", unique = true, length = 50, nullable = false)
    private String location;

    @Column(name = "NUMBER_OF_SEATS", length = 3, unique = true, nullable = false)
    private int numberOfSeats;

   public Cinemas(){}

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}