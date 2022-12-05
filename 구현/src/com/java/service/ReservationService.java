package com.java.service;

import java.sql.SQLException;
import java.util.List;

import com.java.dto.MemberVO;
import com.java.dto.ReservationSeatVO;
import com.java.dto.ReservationVO;

public interface ReservationService {

	
	List<ReservationVO> getReservationList(MemberVO member, String regDate)throws SQLException;	
	
	ReservationVO getReservation(String reservation_num)throws SQLException;
	
	void regist(ReservationVO reservation) throws SQLException;

	void modify(ReservationVO reservation) throws SQLException;
	
	void remove(String reservation_number) throws SQLException;
	
	List<ReservationSeatVO> getReservationSeat(String theater_num)throws SQLException;

}
