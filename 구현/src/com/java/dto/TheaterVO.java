package com.java.dto;

import java.util.Date;
import java.util.List;

public class TheaterVO {

	private String theater_identical_number;
	private String theater_location;
	private String theater_name;
	private Date theater_starttime; 
	private String theater_seat_row; 
	private String theater_seat_col; 


	List<MovieVO> movies;


	public String getTheater_identical_number() {
		return theater_identical_number;
	}


	public void setTheater_identical_number(String theater_identical_number) {
		this.theater_identical_number = theater_identical_number;
	}


	public String getTheater_location() {
		return theater_location;
	}


	public void setTheater_location(String theater_location) {
		this.theater_location = theater_location;
	}


	public String getTheater_name() {
		return theater_name;
	}


	public void setTheater_name(String theater_name) {
		this.theater_name = theater_name;
	}


	public Date getTheater_starttime() {
		return theater_starttime;
	}


	public void setTheater_starttime(Date theater_starttime) {
		this.theater_starttime = theater_starttime;
	}


	public String getTheater_seat_row() {
		return theater_seat_row;
	}


	public void setTheater_seat_row(String theater_seat_row) {
		this.theater_seat_row = theater_seat_row;
	}


	public String getTheater_seat_col() {
		return theater_seat_col;
	}


	public void setTheater_seat_col(String theater_seat_col) {
		this.theater_seat_col = theater_seat_col;
	}


	public List<MovieVO> getMovies() {
		return movies;
	}


	public void setMovies(List<MovieVO> movies) {
		this.movies = movies;
	}


	@Override
	public String toString() {
		return "TheaterVO [theater_identical_number=" + theater_identical_number + ", theater_location="
				+ theater_location + ", theater_name=" + theater_name + ", theater_starttime=" + theater_starttime
				+ ", theater_seat_row=" + theater_seat_row + ", theater_seat_col=" + theater_seat_col + ", movies="
				+ movies + "]";
	}

	
}
