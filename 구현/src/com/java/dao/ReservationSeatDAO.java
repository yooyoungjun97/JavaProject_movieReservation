package com.java.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.dto.ReservationSeatVO;

public interface ReservationSeatDAO {
	
	List<ReservationSeatVO> selectReservationSeat(String reservation_number)throws SQLException;
	
	List<ReservationSeatVO> selectReservationSeatByTheater(String theater_identical_number)throws SQLException;
	
	void insertRervationSeat(ReservationSeatVO seat)throws SQLException;
	void deleteRervationSeat(String reservation_num)throws SQLException;
	
	
}
