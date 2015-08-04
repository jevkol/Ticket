package com.kolesnic.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

//@Component
//@Scope("prototype")
@Entity
@Table(name = "SCHEDULE")
public class  Schedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;




    private Long movieID;


    private  Long cinemaID;


    private Calendar date;


//    private Cinemas cinemas;
//    @ManyToOne( optional = false)
//    @JoinColumn(name = "CINEMA_ID")
//    public Cinemas getCinemas() {return this.cinemas;}
//    public void setCinemas(Cinemas cinemas) {this.cinemas = cinemas;}


    public Schedule(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="MOVIE_ID", nullable = false, length = 4)
    public Long getMovieID() {
        return movieID;
    }

    public void setMovieID(Long movieID) {
        this.movieID = movieID;
    }

    @Column( name="CINEMA_ID", nullable = false, length = 4)
    public Long getCinemaID() {
        return cinemaID;
    }

    public void setCinemaID(Long cinemaID) {
        this.cinemaID = cinemaID;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name="DATE", nullable = false)
    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }


}
