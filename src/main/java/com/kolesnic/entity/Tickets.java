package com.kolesnic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "TICKETS")
public class Tickets {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;


	@Column(name = "NAME")
	private String name;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "MOVIE_ID")
	private int movieId;
	
	@Column(name = "CINEMA_ID")
	private int cinemaId;

	@Temporal(value=TemporalType.DATE)
	@Column(name = "DATE")
	private Date dateAndTime;

	public Tickets() {
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int  getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public int getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}

	public Date getDate() {
		return dateAndTime;
	}

	public void setDate(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

}