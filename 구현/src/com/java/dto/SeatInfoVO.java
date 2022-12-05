package com.java.dto;

public class SeatInfoVO {

	private String seat_info_row_num;
	private String seat_info_colnum;

	private String theater_identical_number;

	public String getSeat_info_row_num() {
		return seat_info_row_num;
	}

	public void setSeat_info_row_num(String seat_info_row_num) {
		this.seat_info_row_num = seat_info_row_num;
	}

	public String getSeat_info_colnum() {
		return seat_info_colnum;
	}

	public String getTheater_identical_number() {
		return theater_identical_number;
	}

	public void setTheater_identical_number(String theater_identical_number) {
		this.theater_identical_number = theater_identical_number;
	}

	public void setSeat_info_colnum(String seat_info_colnum) {
		this.seat_info_colnum = seat_info_colnum;
	}


	@Override
	public String toString() {
		return seat_info_row_num + "," + seat_info_colnum + ","  + "\n";
	}

}
