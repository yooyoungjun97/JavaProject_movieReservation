package com.java.service;

import java.sql.SQLException;
import java.util.List;

import com.java.dao.ReservationDAO;
import com.java.dao.ReservationDAOImpl;
import com.java.dao.ReservationSeatDAO;
import com.java.dao.ReservationSeatDAOImpl;
import com.java.dto.MemberVO;
import com.java.dto.ReservationSeatVO;
import com.java.dto.ReservationVO;
import com.java.util.IdenticalNumberGenerator;

public class ReservationServiceImpl implements ReservationService {

	private ReservationDAO reservationDAO = new ReservationDAOImpl();
	private ReservationSeatDAO reservationSeatDAO = new ReservationSeatDAOImpl();

	@Override
	public List<ReservationVO> getReservationList(MemberVO member, String regDate) throws SQLException {
		List<ReservationVO> reservationList = reservationDAO.selectSearchReservationList(member, regDate);
		if (reservationList != null)
			for (ReservationVO reservation : reservationList) {
				List<ReservationSeatVO> seatList 
				= reservationSeatDAO.selectReservationSeat(reservation.getReservation_number());
				reservation.setSeatList(seatList);
						
			}
		return reservationList;
	}

	@Override
	public ReservationVO getReservation(String reservation_number) throws SQLException {
		ReservationVO reservation = reservationDAO.selectReservationByReservation_number(reservation_number);
		return reservation;
	}

	@Override
	public void regist(ReservationVO reservation) throws SQLException {
		reservation.setReservation_number(IdenticalNumberGenerator.getIdenticalNumber());
		
		reservationDAO.insertReservation(reservation);
		
		List<ReservationSeatVO> seats = reservation.getSeatList();
		for(ReservationSeatVO seat : seats) {
			seat.setReservation_num(reservation.getReservation_number());
			reservationSeatDAO.insertRervationSeat(seat);
		}
	}

	@Override
	public void modify(ReservationVO reservation) throws SQLException {
		reservationDAO.updateReservation(reservation);

	}

	@Override
	public void remove(String reservation_number) throws SQLException {
		reservationDAO.deleteReservation(reservation_number);
	}

	@Override
	public List<ReservationSeatVO> getReservationSeat(String theater_num) throws SQLException {
		List<ReservationSeatVO> seatList
			= reservationSeatDAO.selectReservationSeatByTheater(theater_num);		
		return seatList;
	}

}
