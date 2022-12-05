package com.java.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.dto.MemberVO;
import com.java.dto.ReservationVO;

public interface ReservationDAO {
	List<ReservationVO> selectSearchReservationList(MemberVO member, String reservationDate) throws SQLException;

	ReservationVO selectReservationByReservation_number(String reservation_number) throws SQLException; // 예매번호 조회

	void insertReservation(ReservationVO reservation) throws SQLException; // 삽입

	void updateReservation(ReservationVO reservation) throws SQLException; // 갱신

	void deleteReservation(String reservation_number)throws SQLException;
	
	

}
