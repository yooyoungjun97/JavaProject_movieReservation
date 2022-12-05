package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.datasource.DataSource;
import com.java.dto.ReservationSeatVO;

public class ReservationSeatDAOImpl implements ReservationSeatDAO {

	private DataSource dataSource = DataSource.getInstance();
	
	private List<ReservationSeatVO> getReservationSeatList(ResultSet rs) throws SQLException {
		ReservationSeatVO reservationseat = null;
		List<ReservationSeatVO> reservationSeatList = new ArrayList<ReservationSeatVO>();
		while (rs.next()) {

			reservationseat = new ReservationSeatVO();
			reservationseat.setSeat_choice_num(rs.getString("seat_choice_num"));
			reservationseat.setReservation_num(rs.getString("reservation_num"));
			

			reservationSeatList.add(reservationseat);
		}

		return reservationSeatList;
	}
	
	@Override
	public List<ReservationSeatVO> selectReservationSeat(String reservation_number) throws SQLException {
		
		List<ReservationSeatVO> reservationSeatList = null; 
		
		Connection conn = dataSource.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select * from reservation_Seat where reservation_num = '"+reservation_number+"'";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		reservationSeatList = getReservationSeatList(rs);
		
		
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
		
		return reservationSeatList;		
		
	}
	
	@Override
	public List<ReservationSeatVO> selectReservationSeatByTheater(String theater_identical_number) throws SQLException {
		List<ReservationSeatVO> reservationSeatList = null; 
		
		Connection conn = dataSource.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select * from reservation_Seat where theater_identical_number = '"+theater_identical_number+"'";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		reservationSeatList = getReservationSeatList(rs);
		
		
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
		
		return reservationSeatList;		
	}

	@Override
	public void insertRervationSeat(ReservationSeatVO seat) throws SQLException {
		Connection conn = dataSource.getConnection();
		String sql = "insert into reservation_seat(seat_choice_num,reservation_num,theater_identical_number) "
				+"values(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,seat.getSeat_choice_num());
		pstmt.setString(2,seat.getReservation_num());
		pstmt.setString(3,seat.getTheater_indentical_number());
		
		pstmt.executeUpdate();
		
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}

	@Override
	public void deleteRervationSeat(String reservation_num) throws SQLException {
		Connection conn = dataSource.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "delete from reservation_seat where reservation_num = '"
					+reservation_num+"'";
		stmt.executeUpdate(sql);
		
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
	}



}
