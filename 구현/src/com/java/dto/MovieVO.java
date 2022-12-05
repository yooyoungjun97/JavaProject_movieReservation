package com.java.dto;

import java.util.Date;

public class MovieVO {

	private String movie_identical_number;
	private String movie_title;
	private Date movie_runtime;
	private String movie_director;
	private String movie_actor;
	private String movie_genre;
	private Date movie_releasedate;
	private String movie_rating;
	private String movie_description;

	public String getMovie_identical_number() {
		return movie_identical_number;
	}

	public void setMovie_identical_number(String movie_identical_number) {
		this.movie_identical_number = movie_identical_number;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}

	public Date getMovie_runtime() {
		return movie_runtime;
	}

	public void setMovie_runtime(Date movie_runtime) {
		this.movie_runtime = movie_runtime;
	}

	public String getMovie_director() {
		return movie_director;
	}

	public void setMovie_director(String movie_director) {
		this.movie_director = movie_director;
	}

	public String getMovie_actor() {
		return movie_actor;
	}

	public void setMovie_actor(String movie_actor) {
		this.movie_actor = movie_actor;
	}

	public String getMovie_genre() {
		return movie_genre;
	}

	public void setMovie_genre(String movie_genre) {
		this.movie_genre = movie_genre;
	}

	public Date getMovie_releasedate() {
		return movie_releasedate;
	}

	public void setMovie_releasedate(Date movie_releasedate) {
		this.movie_releasedate = movie_releasedate;
	}

	public String getMovie_rating() {
		return movie_rating;
	}

	public void setMovie_rating(String movie_rating) {
		this.movie_rating = movie_rating;
	}

	public String getMovie_Description() {
		return movie_description;
	}

	public void setMovie_Description(String description) {
		this.movie_description = description;
	}

	@Override
	public String toString() {
		return movie_identical_number + "," + movie_title + "," + movie_runtime + "," + movie_director + ","
				+ movie_actor + "," + movie_genre + "," + movie_releasedate + "," + movie_rating + ","
				+ movie_description + "\n";
	}




}
