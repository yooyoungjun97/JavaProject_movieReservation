package com.java.dto;

import java.util.Date;
import java.util.List;


public class ReservationVO {
	
	private String reservation_number;
	private Date reservation_date; // 예매일자

	private String member_phone_num;
	private String cinema_identical_number;
	private String theater_identical_number;
	private String movie_identical_number;
	private String reservation_payment;
	private Date reservation_regdate;


	private List<ReservationSeatVO> seatList;


	public String getReservation_number() {
		return reservation_number;
	}


	public void setReservation_number(String reservation_number) {
		this.reservation_number = reservation_number;
	}


	public Date getReservation_date() {
		return reservation_date;
	}


	public void setReservation_date(Date reservation_date) {
		this.reservation_date = reservation_date;
	}


	public String getMember_phone_num() {
		return member_phone_num;
	}


	public void setMember_phone_num(String member_phone_num) {
		this.member_phone_num = member_phone_num;
	}


	public String getCinema_identical_number() {
		return cinema_identical_number;
	}


	public void setCinema_identical_number(String cinema_identical_number) {
		this.cinema_identical_number = cinema_identical_number;
	}


	public String getTheater_identical_number() {
		return theater_identical_number;
	}


	public void setTheater_identical_number(String theater_identical_number) {
		this.theater_identical_number = theater_identical_number;
	}


	public String getMovie_identical_number() {
		return movie_identical_number;
	}


	public void setMovie_identical_number(String movie_identical_number) {
		this.movie_identical_number = movie_identical_number;
	}


	public String getReservation_payment() {
		return reservation_payment;
	}


	public void setReservation_payment(String reservation_payment) {
		this.reservation_payment = reservation_payment;
	}


	public List<ReservationSeatVO> getSeatList() {
		return seatList;
	}


	public void setSeatList(List<ReservationSeatVO> seatList) {
		this.seatList = seatList;
	}


	public Date getReservation_regdate() {
		return reservation_regdate;
	}


	public void setReservation_regdate(Date reservation_regdate) {
		this.reservation_regdate = reservation_regdate;
	}

	

}
