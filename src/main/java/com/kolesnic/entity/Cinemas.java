package com.kolesnic.entity;

import javax.persistence.*;
import com.kolesnic.entity.Schedule;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "CINEMAS")
//@NamedQueries({
//@NamedQuery(name="Contact.findAllWithDetail",
//query="select distinct c from Cinemas c left join fetch c.schedules ")
//})
public class Cinemas implements Serializable{


    private Long id;


    private String name;


    private String location;


    private int numberOfSeats;



//    private Set<Schedule>schedules = new HashSet<Schedule>();

//    @OneToMany(cascade = CascadeType.ALL, mappedBy="cinemas")
//    public Set<Schedule> getSchedules() {return this.schedules;}
//    public void setSchedules(Set<Schedule> schedules){this.schedules = schedules;}


    public Cinemas(){}
    @Column(name = "Name", unique = true, length = 30, nullable = false)
    public String getName() {
        return name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CINEMA_ID", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Column(name = "ADRES", unique = true, length = 50, nullable = false)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    @Column(name = "NUMBER_OF_SEATS", length = 3, unique = true, nullable = false)
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String toString() {
        return "Cinema - Id: " + id + ", Name: " + name
                + ", Description: " + location + ", Number of seats: " + numberOfSeats;
    }
}