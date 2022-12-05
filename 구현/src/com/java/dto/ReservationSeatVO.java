package com.java.dto;

public class ReservationSeatVO {
	
	private String seat_choice_num;
	private String reservation_num;
	private String theater_indentical_number;
	
	
	public String getSeat_choice_num() {
		return seat_choice_num;
	}
	public void setSeat_choice_num(String seat_choice_num) {
		this.seat_choice_num = seat_choice_num;
	}
	public String getReservation_num() {
		return reservation_num;
	}
	public void setReservation_num(String reservation_num) {
		this.reservation_num = reservation_num;
	}
	public String getTheater_indentical_number() {
		return theater_indentical_number;
	}
	public void setTheater_indentical_number(String theater_indentical_number) {
		this.theater_indentical_number = theater_indentical_number;
	}
	@Override
	public String toString() {
		return ""+seat_choice_num;
	}
	
	
}
