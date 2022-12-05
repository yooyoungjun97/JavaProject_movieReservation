package com.java.dto;

import java.util.List;

public class CinemaVO {

	private String cinema_identical_number;
	private String cinema_name; // 전화번호
	private String cinema_branch;
	private String cinema_address;
	private String cinema_telephone;
	
	List<TheaterVO> theater;

	public String getCinema_identical_number() {
		return cinema_identical_number;
	}

	public void setCinema_identical_number(String cinema_identical_number) {
		this.cinema_identical_number = cinema_identical_number;
	}

	public String getCinema_name() {
		return cinema_name;
	}

	public void setCinema_name(String cinema_name) {
		this.cinema_name = cinema_name;
	}

	public String getCinema_branch() {
		return cinema_branch;
	}

	public void setCinema_branch(String cinema_branch) {
		this.cinema_branch = cinema_branch;
	}

	public String getCinema_address() {
		return cinema_address;
	}

	public void setCinema_address(String cinema_address) {
		this.cinema_address = cinema_address;
	}

	public String getCinema_telephone() {
		return cinema_telephone;
	}

	public void setCinema_telephone(String cinema_telephone) {
		this.cinema_telephone = cinema_telephone;
	}

	public List<TheaterVO> getTheater() {
		return theater;
	}

	public void setTheater(List<TheaterVO> theater) {
		this.theater = theater;
	}
	

	

}
